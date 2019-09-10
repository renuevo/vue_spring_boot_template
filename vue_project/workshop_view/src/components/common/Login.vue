<template>
  <form method="post" class="ui large form" @submit.prevent="loginPost">
    <div class="ui stacked">
      <div :class="[{'error':login_fail},'field']">
        <div class="ui left icon input">
          <i class="user icon"></i>
          <input type="text" v-model="username" placeholder="Your ID"/>
        </div>
      </div>
      <div :class="[{'error':login_fail},'field']">
        <div class="ui left icon input">
          <i class="lock icon"></i>
          <input type="password" v-model="password" placeholder="Password"/>
        </div>
      </div>
      <button type="submit" class="ui fluid large teal submit button">Login</button>
    </div>
  </form>
</template>

<script>
  import { mapActions, mapGetters } from 'vuex'
  export default {
    name: "Login",
    data() {
      return {
        login_fail: false,
        username: "",
        password: ""
      }
    },
    methods: {
      ...mapActions(['login']),
      loginPost: async function () {
        try {
          let loginResult = await this.login(this.username, this.password);
        }catch (e) {
          this.login_fail = true;
        }

      }
    }
  }
</script>

<style scoped>

</style>
