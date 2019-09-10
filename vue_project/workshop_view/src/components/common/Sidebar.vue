<template>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div v-if="login_state" class="pull-left image">
          <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form class="sidebar-form">
        <div class="input-group">
          <input type="text" class="form-control" v-model="search" placeholder="Search...">
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <!-- Optionally, you can add icons to the links -->
      <transition-group
        class="sidebar-menu"
        data-widget="tree"
        name="staggered-fade"
        tag="ul"
        v-bind:css="false"
        v-on:before-enter="beforeEnter"
        v-on:enter="enter"
        v-on:leave="leave">
        <li v-for="side_item in computedList" :key="side_item.data">
          <router-link :to="side_item.link"><i :class="side_item.class_list"></i> <span class="menu-mini-pop">{{side_item.data}}</span>
          </router-link>
        </li>
      </transition-group>
      <!--
      <li class="treeview">
        <a href="#"><i class="fa fa-money-check-alt"></i> <span>Salary 외부정보</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
        <ul class="treeview-menu">
          <li><a href="#">국민연금</a></li>
          <li><a href="#">알리오</a></li>
        </ul>
      </li>
      -->
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
</template>

<script>

  export default {
    name: "Sidebar",
    data() {
      return {
        login_state: false,
        search: '',
        side_items: [
          {link: this.$context_name+'/', class_list: 'fa fa-chart-line', data: 'Test'},
          {link: this.$context_name+'/list_info', class_list: 'fa fa-kaaba', data: 'List Info'},
          {link: this.$context_name+'/matching_info', class_list: 'fa fa-address-book', data: 'Matching Info'},
          {link: this.$context_name+'/company_info', class_list: 'fa fa-database', data: 'Company Info'}
        ]
      }
    },
    computed: {
      computedList: function () {
        return this.side_items.filter(item => {
          return item.data.toLowerCase().indexOf(this.search.toLowerCase()) !== -1
        })
      }
    }, methods: {
      beforeEnter: function (el) {
        el.style.opacity = 0
        el.style.height = 0
      },
      enter: function (el, done) {
        var delay = el.dataset.index * 150
        setTimeout(function () {
          $(el).animate(
            {opacity: 1, height: '43px'},
            {complete: done}
          )
        }, delay)
      },
      leave: function (el, done) {
        var delay = el.dataset.index * 150
        setTimeout(function () {
          $(el).animate(
            {opacity: 0, height: 0},
            {complete: done}
          )
        }, delay)
      }
    }
  }
</script>

<style scoped>
  .sidebar-mini.sidebar-collapse .sidebar-menu>li:not(.treeview)>a>span {
    background-color: #2c3b41 !important;
    color: white;
  }
</style>
