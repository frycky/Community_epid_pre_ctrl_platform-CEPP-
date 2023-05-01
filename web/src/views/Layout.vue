<template>
  <div>
    <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside width="200px" style="overflow: hidden">
        <h3 class="title">用户管理系统
        </h3>
        <el-menu :default-openeds="['1', '3']"
                 style="border-right:none"
        >
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>导航一</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">
                <router-link tag="div" to="/test">测试页面test</router-link>

              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link tag="div" to="/test2">测试页面test2</router-link>
              </el-menu-item>

              <el-menu-item index="1-3">
                <router-link tag="div" to="/categoryManage">栏目管理</router-link>
              </el-menu-item>
              <el-menu-item index="1-4">
                <router-link tag="div" to="/articleManage">文章管理</router-link>
              </el-menu-item>
              <el-menu-item index="1-5">
                <router-link tag="div" to="/userManage">用户管理</router-link>
              </el-menu-item>
              <el-menu-item index="1-6">
                <router-link tag="div" to="/userTypeManage">用户类型</router-link>
              </el-menu-item>
              <el-menu-item index="1-7">
                <router-link tag="div" to="/menuManage">菜单管理</router-link>
              </el-menu-item>
            </el-menu-item-group>

<!--            <el-menu-item-group title="分组2">-->
<!--              <el-menu-item index="1-6">选项3</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-submenu index="1-7">-->
<!--              <template slot="title">选项4</template>-->
<!--              <el-menu-item index="1-7-1">选项4-1</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </el-submenu>-->
<!--          <el-submenu index="2">-->
<!--            <template slot="title"><i class="el-icon-menu"></i>导航二</template>-->
<!--            <el-menu-item-group>-->
<!--              <template slot="title">分组一</template>-->
<!--              <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--              <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-menu-item-group title="分组2">-->
<!--              <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-submenu index="2-4">-->
<!--              <template slot="title">选项4</template>-->
<!--              <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
<!--            </el-submenu>-->
<!--          </el-submenu>-->
<!--          <el-submenu index="3">-->
<!--            <template slot="title"><i class="el-icon-setting"></i>导航三</template>-->
<!--            <el-menu-item-group>-->
<!--              <template slot="title">分组一</template>-->
<!--              <el-menu-item index="3-1">选项1</el-menu-item>-->
<!--              <el-menu-item index="3-2">选项2</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-menu-item-group title="分组2">-->
<!--              <el-menu-item index="3-3">选项3</el-menu-item>-->
<!--            </el-menu-item-group>-->
<!--            <el-submenu index="3-4">-->
<!--              <template slot="title">选项4</template>-->
<!--              <el-menu-item index="3-4-1">选项4-1</el-menu-item>-->
<!--            </el-submenu>-->
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <span class="el-dropdown-link">
              张三<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <!--              <el-dropdown-item disabled>双皮奶</el-dropdown-item>-->
              <el-dropdown-item divided>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>

        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      text:"",
      tableData: [],
      multipleSelection: []
    }
  },
  methods: {
    //根据用户权限获取菜单栏

    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  }
};
</script>

<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}

/*更改下拉框的样式*/
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}

.el-icon-arrow-down {
  font-size: 12px;
}

.title {
  text-align: center;
  background-color: #FFF;
  height: 30px;
  line-height: 30px;
  margin-top: 11px;
}
.input{
  width: 200px!important;
  margin-right: 10px;
}
.mr10px{
  margin-right: 10px;
}
.pb10px{
  padding-bottom: 10px;
}
</style>