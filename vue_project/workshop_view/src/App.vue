<template>
  <div id="app">
    <Header></Header>
    <SideBar></SideBar>
    <div class="content-wrapper">
      <transition name="component-fade" mode="out-in">
        <router-view></router-view>
        <!--<router-view name="header"></router-view>-->
      </transition>
    </div>
  </div>
</template>

<script>

  import Header from "./components/common/Header";
  import SideBar from "./components/common/Sidebar";

  export default {
    name: 'App',
    components: {Header, SideBar}
  }
</script>


<style>

  .component-fade-enter-active, .component-fade-leave-active {
    transition: all .3s ease;
  }

  .component-fade-enter, .component-fade-leave-to {
    opacity: 0;
  }

  #app{
    position: relative;
  }

</style>
