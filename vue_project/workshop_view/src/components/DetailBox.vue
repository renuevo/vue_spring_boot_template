<template>
  <div class="box">
    <div class="box-header">
      <h3 class="box-title">{{graphData.name}}</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body no-padding">
      <table class="table table-condensed">
        <tbody>
        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">정직성(HonestyHumility)</th>
          <th style="width: 55%"></th>
          <th>{{graphData.honestyHumility*20}}%</th>
          <th style="width: 40px">Label</th>
        </tr>
        <tr>
          <td>1.</td>
          <td>진실성<br/>Sincerity</td>
          <td><b>인간관계에서 얼마나 진솔한지를 말해준다.</b> <br/>점수가 낮은 사람들은 이익을 위해서 아부를 하거나 좋아하는 척하며<br/> 높은 점수를 받은 사람들은 남을 조종하려하지 않는다</td>
          <td>
            <div class="ui blue active progress">
              <div class="bar" :style="{width: (graphData.sincerity*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-blue">{{graphData.sincerity*20}}%</span></td>
        </tr>
        <tr>
          <td>2.</td>
          <td>공정성<br/>Fariness</td>
          <td><b>사기와 부패에 대한 경향성을 말해준다.</b> <br/>점수가 낮은 사람들은 사기나 도둑질을 해서라도 이득을 취하려고 하지만<br/>높은 사람들은 타인이나 사회를 이용하려고 하지 않는다</td>
          <td>
            <div class="ui blue active progress">
              <div class="bar" :style="{width: (graphData.fairness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-blue">{{graphData.fairness*20}}%</span></td>
        </tr>
        <tr>
          <td>3.</td>
          <td>탐욕없음<br/>Greed_avoidance</td>
          <td><b>막대한 부, 사치품, 높은 사회적 지위에 대한 욕심이 없는지에 대한 척도다.</b><br/>점수가 낮은 사람들은 부와 권력을 좋아하고 과시하며<br/> 반면에 점수가 높은 사람들은 딱히 돈이나 사회적 지위에 의해 동기부여 되지 않는다</td>
          <td>
            <div class="ui blue active progress">
              <div class="bar" :style="{width: (graphData.greedAvoidance*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-blue">{{graphData.greedAvoidance*20}}%</span></td>
        </tr>
        <tr>
          <td>4.</td>
          <td>겸손<br/>Modesty</td>
          <td><b>겸손하고 잘난척하지 않는 경향을 나타낸다.</b><br/>점수가 낮은 사람들은 자신이 남보다 우월하며 다른 사람이 가지지 않은 특권을 가질 권리가 있다고 생각하며,<br/> 반면에 점수가 높은 사람들은 그들을 평범한 사람으로 여기며 특별한 대접을 바라지 않는다</td>
          <td>
            <div class="ui blue active progress">
              <div class="bar" :style="{width: (graphData.modesty*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-blue">{{graphData.modesty*20}}%</span></td>
        </tr>

        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">정서성(Emotionality)</th>
          <th style="width: 55%"></th>
          <th>{{graphData.emotionality*20}}%</th>
          <th style="width: 40px">Label</th>
        </tr>
        <tr>
          <td>1.</td>
          <td>공포<br/>Fearfulness</td>
          <td><b>공포를 느끼는 경향을 나타낸다.</b> <br/>점수가 낮은 사람들은 다치는 것에 대해 많이 두려워하지 않고 용감하며<br/>높은 사람들은 물리적인 위험을 피하려는 경향이 강하다</td>
          <td>
            <div class="ui red active progress">
              <div class="bar" :style="{width: (graphData.fearfulness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-red">{{graphData.fearfulness*20}}%</span></td>
        </tr>
        <tr>
          <td>2.</td>
          <td>걱정<br/>Anxiety</td>
          <td><b>다양한 상황에서 걱정하는 경향을 나타낸다.</b> <br/>점수가 낮은 사람들은 어려운 일이 생겨도 별로 스트레스를 받지 않으며<br/> 높은 사람들은 비교적 작은 문제에도 몰두하는 경향이 있다</td>
          <td>
            <div class="ui red active progress">
              <div class="bar" :style="{width: (graphData.anxiety*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-red">{{graphData.anxiety*20}}%</span></td>
        </tr>
        <tr>
          <td>3.</td>
          <td>의지<br/>Dependence</td>
          <td><b>다른 사람으로부터의 정서적 지지에 대한 필요를 나타낸다.</b><br/>점수가 낮은 사람들은 자신이 있고, 다른 사람의 도움이나 조언 없이 문제를 해결하며,<br/> 높은 사람들은 지지를 원하며, 자기 편과 문제를 상의하고자 한다</td>
          <td>
            <div class="ui red active progress">
              <div class="bar" :style="{width: (graphData.dependence*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-red">{{graphData.dependence*20}}%</span></td>
        </tr>
        <tr>
          <td>4.</td>
          <td>정감<br/>Sentimentality</td>
          <td><b>다른 사람과의 강한 정서적 유대감에 대한 척도이다.</b><br/>점수가 낮은 사람은 이별이나 다른 사람의 고민에 별 감정을 느끼지 않는다<br/> 점수가 높은 사람들은 다른 사람과의 강한 정서적 연결을 느끼며 다른 사람의 감정에 공감한다</td>
          <td>
            <div class="ui red active progress">
              <div class="bar" :style="{width: (graphData.sentimentality*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-red">{{graphData.sentimentality*20}}%</span></td>
        </tr>


        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">외향성(extraversion)</th>
          <th style="width: 55%"></th>
          <th>{{graphData.extraversion*20}}%</th>
          <th style="width: 40px">Label</th>
        </tr>
        <tr>
          <td>1.</td>
          <td>사회적 존재감<br/>Social self_esteem</td>
          <td><b>사회적인 맥락에서 긍정적인 자아상을 가지는 경향성을 말해준다</b> <br/>점수가 높은 사람은 그들 자신에 대해 대체로 만족하며 사람들이 그들을 좋아할만 하다고 여기고,<br/> 점수가 낮은 사람들은 자신이 인기 없다고 여긴다</td>
          <td>
            <div class="ui orange active progress">
              <div class="bar" :style="{width: (graphData.socialSelfEsteem*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-orange">{{graphData.socialSelfEsteem*20}}%</span></td>
        </tr>
        <tr>
          <td>2.</td>
          <td>사회적 대담성<br/>Social boldness</td>
          <td><b>다양한 사회적 상황에서의 자신감과 편안함을 말해준다.</b> <br/>점수가 낮은 사람들은 리더 역할을 하거나 대중 앞에서 발표를 할 때 뻘쭘해 하며, <br/>높은 사람들은 낯선 사람에게도 잘 다가고 집단에 있을 때 말을 잘 한다</td>
          <td>
            <div class="ui orange active progress">
              <div class="bar" :style="{width: (graphData.socialBoldness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-orange">{{graphData.socialBoldness*20}}%</span></td>
        </tr>
        <tr>
          <td>3.</td>
          <td>사교성<br/>Sociability</td>
          <td><b>대화나 사회적 상호작용, 파티를 즐기는 경향성을 나타낸다</b><br/>점수가 낮은 사람들은 혼자 하는 활동을 좋아하고 말을 많이 하지 않는다<br/>점수가 높은 사람들은 말하는 걸 좋아하고 친구 집에 놀러가거나 연회에 가기를 좋아한다</td>
          <td>
            <div class="ui orange active progress">
              <div class="bar" :style="{width: (graphData.sociability*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-orange">{{graphData.sociability*20}}%</span></td>
        </tr>
        <tr>
          <td>4.</td>
          <td>활발함<br/>Liveliness</td>
          <td><b>개인의 열정과 에너지를 나타낸다.</b><br/>점수가 낮은 사람은 딱히 흥이 넘치지 않으며 점수가 높은 사람들은 낙관적이며 약간의 조증을 가지고 있다</td>
          <td>
            <div class="ui orange active progress">
              <div class="bar" :style="{width: (graphData.liveliness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-orange">{{graphData.liveliness*20}}%</span></td>
        </tr>



        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">원만성(agreeableness)</th>
          <th style="width: 55%"></th>
          <th>{{graphData.agreeableness*20}}%</th>
          <th style="width: 40px">Label</th>
        </tr>
        <tr>
          <td>1.</td>
          <td>용서<br/>Forgiveness</td>
          <td><b>다른 사람을 용서하고 해를 끼쳤던 사람이라도 다시 믿는 경향을 말한다</b> <br/>점수가 낮은 사람들은 그들에게 피해를 준 사람에게 원한을 갖으며,<br/> 점수가 높은 사람들은 타인을 기꺼이 다시 믿으며 안 좋은 일 이후에도 친밀한 관계를 다시 맺으려고 한다</td>
          <td>
            <div class="ui teal active progress">
              <div class="bar" :style="{width: (graphData.forgiveness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-teal">{{graphData.forgiveness*20}}%</span></td>
        </tr>
        <tr>
          <td>2.</td>
          <td>온화함<br/>Gentleness</td>
          <td><b>부드럽고 너그럽게 타인을 대하는 경향이다</b> <br/>점수가 낮은 사람들은 타인에 대해 비평적인 반면에 점수가 높은 사람들은 매정하게 상대를 판단하질 못한다</td>
          <td>
            <div class="ui teal active progress">
              <div class="bar" :style="{width: (graphData.gentleness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-teal">{{graphData.gentleness*20}}%</span></td>
        </tr>
        <tr>
          <td>3.</td>
          <td>유연함<br/>Flexibility</td>
          <td><b>다른 사람과 타협하고 협조하려는 성향을 나타낸다</b><br/>점수가 낮은 사람들은 완고하고 언쟁도 불사하지만 높은 사람들은 언쟁을 피하고 남의 의견을 수용한다 (비합리적이라도..)</td>
          <td>
            <div class="ui teal active progress">
              <div class="bar" :style="{width: (graphData.flexibility*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-teal">{{graphData.flexibility*20}}%</span></td>
        </tr>
        <tr>
          <td>4.</td>
          <td>인내심<br/>Patience</td>
          <td><b>화를 내지 않는 경향을 말한다.</b><br/>점수가 낮은 사람들은 금방 화를 내는데 반해 점수가 높은 사람들은 화를 느끼고 표현하는 데에 기준선이 높다</td>
          <td>
            <div class="ui teal active progress">
              <div class="bar" :style="{width: (graphData.patience*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-teal">{{graphData.patience*20}}%</span></td>
        </tr>


        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">성실성(conscientiousness)</th>
          <th style="width: 55%"></th>
          <th>{{graphData.conscientiousness*20}}%</th>
          <th style="width: 40px">Label</th>
        </tr>
        <tr>
          <td>1.</td>
          <td>체계성<br/>Organization</td>
          <td><b>질서를 좇는 경향이다</b> <br/>점수가 낮은 사람들은 헐렁하고 무계획적이며 점수가 높은 사람들은 주변을 깔끔하게 정돈하고 일에도 체계적으로 접근한다</td>
          <td>
            <div class="ui green active progress">
              <div class="bar" :style="{width: (graphData.organization*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-green">{{graphData.organization*20}}%</span></td>
        </tr>
        <tr>
          <td>2.</td>
          <td>근면성<br/>Diligence</td>
          <td><b>일을 열심히 하는 경향을 나타낸다</b> <br/>점수가 낮은 사람들은 자기 절제가 약하고 성취에 집착하지 않으며 점수가 높은 사람들은 근면하고 자신을 몰아부친다</td>
          <td>
            <div class="ui green active progress">
              <div class="bar" :style="{width: (graphData.diligence*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-green">{{graphData.diligence*20}}%</span></td>
        </tr>
        <tr>
          <td>3.</td>
          <td>완벽주의<br/>Perfectionism</td>
          <td><b>철저하고 세부 사항까지 신경 쓰는 경향이다</b><br/>점수가 낮은 사람들은 약간 결점이 있어도 넘어가고 세부 사항에 연연하지 않는 다<br/>
            높은 사람들은 실수가 없나 하나하나 꼼꼼히 확인하고 더 나은 방법이 없나 살핀다</td>
          <td>
            <div class="ui green active progress">
              <div class="bar" :style="{width: (graphData.perfectionism*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-green">{{graphData.perfectionism*20}}%</span></td>
        </tr>
        <tr>
          <td>4.</td>
          <td>신중성<br/>Prudence</td>
          <td><b>신중히 생각하고 충동을 억누르는 경향이다</b><br/>점수가 낮은 사람들은 충동적으로 행동하며 결과를 생각하지 않는다<br/>점수가 높은 사람들은 그들의 선택지를 곰곰이 생각하고 주의하며 자제한다</td>
          <td>
            <div class="ui green active progress">
              <div class="bar" :style="{width: (graphData.prudence*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-green">{{graphData.prudence*20}}%</span></td>
        </tr>


        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">개방성(openness to experience)</th>
          <th style="width: 55%"></th>
          <th>{{graphData.opennessToExperience*20}}%</th>
          <th style="width: 40px">Label</th>
        </tr>
        <tr>
          <td>1.</td>
          <td>심미안<br/>Aesthetic Appreciation</td>
          <td><b>자연과 예술에서 아름다움을 향유하는 경향성을 나타낸다</b> <br/>점수가 낮은 사람들은 예술작품이나 자연의 신비에 푹 빠져드는 경우가 드물다<br/>반면에 점수가 높은 사람들은 다양한 예술작품이나 자연의 신비에 감탄하곤 한다</td>
          <td>
            <div class="ui purple active progress">
              <div class="bar" :style="{width: (graphData.aestheticAppreciation*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-purple">{{graphData.aestheticAppreciation*20}}%</span></td>
        </tr>
        <tr>
          <td>2.</td>
          <td>호기심<br/>Inquisitiveness</td>
          <td><b>자연과 인간 세계에 대한 정보와 경험을 추구하는 경향성을 나타낸다</b>
            <br/>점수가 낮은 사람들은 자연과학 및 사회과학에 호기심이 적고 점수가 높은 사람들은 이런 것을 많이 읽고 여행에 관심이 많다</td>
          <td>
            <div class="ui purple  active progress">
              <div class="bar" :style="{width: (graphData.inquisitiveness*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-purple">{{graphData.inquisitiveness*20}}%</span></td>
        </tr>
        <tr>
          <td>3.</td>
          <td>창의성<br/>Creativity</td>
          <td><b>혁신과 실험에 대한 선호도를 나타내는 척도다</b><br/>점수가 낮은 사람들은 새로운 생각에 대해 관심이 별로 없고<br/>
            높은 사람들은 적극적으로 새로운 해결책을 찾으며 자신을 예술적으로 표현하기도 한다</td>
          <td>
            <div class="ui purple  active progress">
              <div class="bar" :style="{width: (graphData.creativity*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-purple">{{graphData.creativity*20}}%</span></td>
        </tr>
        <tr>
          <td>4.</td>
          <td>비관습성<br/>Unconventionality</td>
          <td><b>흔치 않은 것을 받아들이는 성향을 나타낸다</b><br/>점수가 낮은 사람들은 괴상하거나 관행을 따르지 않는 사람들을 싫어한다<br/>점수가 높은 사람들은 낯설거나 급진적인 생각들도 잘 받아들인다</td>
          <td>
            <div class="ui purple  active progress">
              <div class="bar" :style="{width: (graphData.unconventionality*20)+'%'}" >
                <div class="progress"></div>
              </div>
            </div>
          </td>
          <td><span class="badge bg-purple">{{graphData.unconventionality*20}}%</span></td>
        </tr>
        <tr>
          <th style="width: 10px">#</th>
          <th style="width: 230px">이타성(Altruism)</th>
          <th style="width: 55%">
            다른 사람들에게 공감하고 따뜻하게 대하는 성향을 나타낸다
          </th>
          <th>
            <div class="ui yellow  active progress">
            <div class="bar" :style="{width: (graphData.altruism*20)+'%'}" >
              <div class="progress"></div>
            </div>
          </div></th>
          <th style="width: 40px"><span class="badge bg-yellow">{{graphData.altruism*20}}%</span></th>
        </tr>
        </tbody>
      </table>
    </div>
    <!-- /.box-body -->
  </div>
</template>

<script>
  export default {
    name: "DetailBox",
    props: ['graphData'],
    created: function(){

    }
  }
</script>

<style scoped>

</style>
