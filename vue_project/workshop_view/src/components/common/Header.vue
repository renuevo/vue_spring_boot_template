<template>
  <!-- Main Header -->
  <header class="main-header">
    <!-- Logo -->
    <a href=".." class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>WS</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Work</b>shop</span>
    </a>
    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <i class="fas fa-bars"></i>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
        </ul>
      </div>
    </nav>
  </header>
</template>

<script>

  export default {
    name: "Header",
    data() {
      return {
        nav_dropdown: false
      }
    },
    computed: {
      login_error_msg: function() {
        return this.$store.getters.getErrorState;
      }
    }
  }
</script>

<style scoped>

  /* override */
  .navbar {
    display: block;
    padding: 0px;
  }

  .nav > li > a {
    position: relative;
    padding: 15px;
    line-height: 20px;
    display: block;
  }

  .main-header .sidebar-toggle:before {
    content: none;
  }

  .slide-fade-enter-active, .slide-fade-leave-active {
    transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
  }

  .slide-fade-enter, .slide-fade-leave-to
    /* .slide-fade-leave-active below version 2.1.8 */
  {
    transform: translateX(-30px);
    opacity: 0;
  }

</style>
