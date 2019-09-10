<template>
  <div class="hello">
    <div v-if="name_login" class="ui middle aligned center aligned grid">
      <div class="login-box">
        <div class="ui stacked segment name_box">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" v-model="name" name="name" placeholder="이름 입력" @keyup.enter="testing_start">
          </div>
          <button class="ui teal button testing_button" @click="testing_start">검사시작</button>
        </div>
      </div>
    </div>
    <transition name="component-fade" mode="in-out">
      <section v-if="!name_login" class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="box">
              <div class="box-header with-border">
                <h3 class="box-title">{{test_msg}}</h3>
              </div>
              <!-- /.box-header -->
              <div class="box-body">
                <div class="row">
                  <div class="ui form">
                    <div v-for="test_item in testList" :key="test_item.num">
                      <label>{{test_item.num}}. {{test_item.problem}}</label>
                      <div class="inline fields">
                        <div class="field">
                          <div class="ui radio checkbox">
                            <input type="radio" :name="test_item.num" value="1" v-model="pick_data[test_item.num]"
                                   checked="checked">
                            <label>1</label>
                          </div>
                        </div>
                        <div class="field">
                          <div class="ui radio checkbox">
                            <input type="radio" :name="test_item.num" value="2" v-model="pick_data[test_item.num]">
                            <label>2</label>
                          </div>
                        </div>
                        <div class="field">
                          <div class="ui radio checkbox">
                            <input type="radio" :name="test_item.num" value="3" v-model="pick_data[test_item.num]">
                            <label>3</label>
                          </div>
                        </div>
                        <div class="field">
                          <div class="ui radio checkbox">
                            <input type="radio" :name="test_item.num" value="4" v-model="pick_data[test_item.num]">
                            <label>4</label>
                          </div>
                        </div>
                        <div class="field">
                          <div class="ui radio checkbox">
                            <input type="radio" :name="test_item.num" value="5" v-model="pick_data[test_item.num]">
                            <label>5</label>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
                <!-- /.row -->
              </div>
              <!-- ./box-body -->
              <div class="box-footer">
                <button class="ui green button" @click="upload_test_data">완 료</button>
              </div>
              <!-- /.box-footer -->
            </div>
            <!-- /.box -->
          </div>
          <!-- /.col -->
        </div>
      </section>
    </transition>

    <button v-show="false" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
      Launch demo modal
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-body">
            <canvas id="chart-area"></canvas>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'MatchingOn',
    data() {
      return {
        name: '',
        name_login: true,
        test_msg: 'test',
        testList: [],
        pick_data: []
      }
    },
    methods: {
      testing_start: function () {
        var test;
        var testType = "hexaco";

        if (this.name === "김재화" || this.name === "observer" || this.name === "김정길" || this.name === "배주현" || this.name === "방상욱" || this.name === "장진후")
          test = "observer";
        else
          test = "self";

        this.$http.get(this.$server_host_name + this.$context_name + "/load_test_data", {
          params: {type: test, testType: testType}
        }).then(res => {
          this.testList = res.data;

          if (test === "self")
            this.test_msg = '나 자신은?';
          else
            this.test_msg = '내가 지금 필요한 사람은?';

          this.name_login = false;
        });
      },
      upload_test_data: function () {
        if (this.testList.length > this.pick_data.length) {
          alert("전부 선택해 주세요");
          return;
        }

        for (var i = 1; i < this.testList.length; i++) {
          if (this.pick_data[i] === undefined) {
            alert(i + "번째를 선택해 주세요");
            return;
          }
        }

        this.$http.get(this.$server_host_name + this.$context_name + "/upload_test_data", {
          params: {type: 'self', testType: 'hexaco', name: this.name, radio_list: encodeURI(this.pick_data)}
        }).then(res => {
          $(".btn-primary").click();
          this.name_login = true;
          var config = {
            data: {
              datasets: [{
                data: [
                  res.data.data.honestyHumility,
                  res.data.data.emotionality,
                  res.data.data.extraversion,
                  res.data.data.agreeableness,
                  res.data.data.conscientiousness,
                  res.data.data.opennessToExperience,
                  res.data.data.altruism
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

          var ctx = document.getElementById('chart-area');
          var myChart = new Chart(ctx, config);
        });
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .name_box {
    height: 80px;
    width: 380px;
  }

  .testing_button {
    margin-left: 10px;
  }

  .row {
    margin: 0px;
  }

  .component-fade-enter-active, .component-fade-leave-active {
    transition: all .5s ease;
  }

  .component-fade-enter, .component-fade-leave-to {
    opacity: 0;
  }
</style>
