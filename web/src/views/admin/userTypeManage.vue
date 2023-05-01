<template>
  <div>
    <div class="pb10px">
      <!--@input="handleSearch"与@click="handleSearch"相绑定，实现输入即搜索-->
      <el-input v-model="searchForm.username" @input="handleSearch" class="input" clearable placeholder="请输入用户名"
                size="small"></el-input>
      <el-button type="primary" icon="el-icon-search" size="small" class="mr10px" @click="handleSearch">搜索</el-button>
    </div>
    <div>
      <el-button @click="handleAdd" type="primary" size="small">新增</el-button>
      <el-button size="small" type="danger" @click="batchDelete" :disabled="ids.length>0 ? false : true">批量删除
      </el-button>
    </div>

    <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
      <el-table-column
          type="selection"
          width="55">
      </el-table-column>
      <el-table-column
          prop="id"
          label="ID"
          width="50">
      </el-table-column>
      <el-table-column
          prop="permission"
          label="用户类型"
          show-overflow-tooltip>
        <template v-slot="scope">
          <span :class="fontLightClass(scope.row.permission)">{{ scope.row.permission }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
              plain
              size="mini"
              type="primary"
              @click="handleChange(scope.row.id)">配置菜单
          </el-button>
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
          </el-button>
          <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--自定义分页组件-->
    <CustomPages
        @current-change="currentChange"
        @size-change="sizeChange"
        :total="pageInfo.total"
        background
        layout="sizes, prev, pager, next"
        :page-sizes="[5,10,20,30]"
        :current-page="pageInfo.pageNum"
    >
    </CustomPages>

    <!--自定义抽屉组件-->
    <CustomDrawer
        :form-data="formData"
        :rules-form="ruleForm"
        @close-drawer="closeDrawer"
        @submit-drawer="submitDrawer"
        :is-drawer-dialog="isDrawerDialog"
    >
      <div slot="content">
        <el-form-item label="用户名称" prop="username">
          <el-input v-model="formData.username" placeholder="请设置用户名称"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="formData.password" placeholder="请设置用户密码"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="formData.email" placeholder="请设置用户邮箱"></el-input>
        </el-form-item>
        <el-form-item label="用户类型" prop="permission">
          <el-switch
              v-model="formData.permission"
              active-color="#13ce66"
              inactive-color="#B3C0D1"
              active-value="管理员"
              inactive-value="普通用户"
              style="padding-left: 10px"
          >
          </el-switch>
        </el-form-item>
      </div>
    </CustomDrawer>

    <!--菜单权限处理弹窗-->
    <el-dialog title="菜单权限管理" :visible.sync="dialogTableVisible">
      <el-table
          :data="menuList"
          ref="multipleTable"
          @selection-change="selectionTableChange"
      >
        <el-table-column
            type="selection"
            width="55">
        </el-table-column>
        <el-table-column property="id" label="id" width="150"></el-table-column>
        <el-table-column property="title" label="菜单名称" width="150"></el-table-column>
        <el-table-column
            property="permission"
            label="目标用户"
            show-overflow-tooltip
        >
          <template v-slot="scope">
            <span :class="fontLightClass(scope.row.permission)">{{ scope.row.permission }}</span>
          </template>
        </el-table-column>
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelTable">取 消</el-button>
        <el-button type="primary" @click="submitEdit">确 定</el-button>
      </span>

    </el-dialog>

  </div>
</template>

<script>

//引入混入
import create from "@/mixins/create"


export default {
  data() {
    return {
      api: {
        pageUrl: "/user_type/pageType",
        saveUrl: "/user_type/save",
        delUrl: "/user_type/delBatch",
      },
      menuList: [],

    }
  },
  mixins: [create],
  created() {
    this.getMenuList()
  },
  methods: {
    fontLightClass(permission) {
      if (permission == "管理员") {
        return 'fGreen'
      }
      if (permission == "普通用户") {
        return 'fGrey'
      }
    },
    getByTypeId(id) {
      this.$axios.get("/user_type/getByTypeId?typeId=" + id).then((res) => {
        this.currentMenuList = res.data
        let empData = []
        res.data.forEach(item => {
          this.menuList.forEach(i => {
            //后端返回的数据与表格中的id进行对比，相同则添加
            if (item.id === i.id) {
              empData.push(i)
            }
          })
        })
        //相同则选中
        empData.forEach(item => {
          this.$refs.multipleTable.toggleRowSelection(item)
        })
      })
    },
    cancelTable(){
      this.$refs.multipleTable.clearSelection()
      this.dialogTableVisible = false
    },
  }
};
</script>

<style scoped>
.fGreen {
  color: limegreen;
}

.fGrey {
  color: #B3C0D1;
}
</style>