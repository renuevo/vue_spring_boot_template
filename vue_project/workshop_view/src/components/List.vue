<template>
  <section class="content">
    <div class="row" v-if="view_list">
      <div class="col-md-12">
        <div class="ui card" v-for="(test_person, index) in data_list">
          <div class="content">
            <a class="header">{{test_person.name}}</a>
            <div class="description">
            </div>
            <canvas :id="'chart_'+test_person.userKey">
            </canvas>
          </div>
          <div class="extra content">
            <a @click="total_info(index)">
              <i class="user icon"></i>
              자세한 결과 보기
            </a>
          </div>
        </div>
      </div>
    </div>
    <div class="row" v-else>
      <div class="col-md-12">
        <DetailBox :graph-data="target_data"></DetailBox>
      </div>
    </div>
  </section>
</template>

<script>

  import DetailBox from "./DetailBox";

  export default {
    name: "List",
    components: {DetailBox},
    data() {
      return {
        data_list: [],
        view_list: true,
        target_data: []
      }
    },
    created: function () {
      this.$http.get(this.$server_host_name + this.$context_name + "/load_test_done_data").then(res => {
        this.data_list = res.data;
        this.initGraph();
      });
    },
    methods: {
      total_info: function (index) {
        this.view_list = false;
        this.target_data = this.data_list[index];
      },
      initGraph() {
        this.$nextTick(() => {
          for (var i = 0; i < this.data_list.length; i++) {
            var config = {
              data: {
                datasets: [{
                  data: [
                    this.data_list[i].honestyHumility,
                    this.data_list[i].emotionality,
                    this.data_list[i].extraversion,
                    this.data_list[i].agreeableness,
                    this.data_list[i].conscientiousness,
                    this.data_list[i].opennessToExperience,
                    this.data_list[i].altruism
                  ],
                  backgroundColor: [
                    'rgba(255,99,132, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(255, 206, 86, 0.5)',
                    'rgba(75, 192, 192, 0.5)',
                    'rgba(153, 102, 255, 0.5)',
                    'rgba(255, 159, 64, 0.5)',
                    'rgba(100, 255, 150, 0.5)',
                  ],
                  label: 'My dataset' // for legend
                }],
                labels: [
                  '정직성',
                  '정서성',
                  '외향성',
                  '원만성',
                  '성실성',
                  '개방성',
                  '이타성'
                ]
              },
              type: 'polarArea',
              options: {
                responsive: true,
                legend: {
                  position: 'right',
                },
                title: {
                  display: true,
                  text: '검사 결과'
                },
                scale: {
                  ticks: {
                    beginAtZero: true,
                    min: 0,
                    max: 5,
                    stepSize: 1
                  },
                  reverse: false
                },
                animation: {
                  animateRotate: false,
                  animateScale: true
                }
              }
            };
            new Chart(document.getElementById('chart_' + this.data_list[i].userKey), config);
          }
        })
      }
    }
  }
</script>

<style scoped>
  .card {
    float: left;
    margin-top: 0px;
    margin-left: 12px;
    width: 500px;
  }
</style>
