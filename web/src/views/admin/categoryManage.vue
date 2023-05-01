<template>
  <div>
    <div class="pb10px">
      <!--@input="handleSearch"与@click="handleSearch"相绑定，实现输入即搜索-->
      <el-input v-model="searchForm.title" @input="handleSearch" class="input" clearable placeholder="请输入标题"
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
          prop="createTime"
          label="发布时间"
          width="170"
          :formatter="formatDateC">
      </el-table-column>
      <el-table-column
          prop="title"
          label="标题"
          show-overflow-tooltip>
      </el-table-column>
      <el-table-column
          prop="status"
          label="状态"
          show-overflow-tooltip>
        <template v-slot="scope">
          <span :class="fontLightClass(scope.row.status)">{{scope.row.status}}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
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
        <el-form-item label="栏目：" prop="title">
          <el-input v-model="formData.title" placeholder="请输入内容"></el-input>
        </el-form-item>
      </div>
    </CustomDrawer>
  </div>
</template>

<script>

//引入混入
import create from "@/mixins/create"


export default {
  data() {
    return {
      api: {
        pageUrl: "/word-info/pageTitle",
        saveUrl: "/word-info/saveTitle",
        delUrl: "/word-info/deleteTitle",
      },
    }
  },
  mixins: [create],
  methods:{
    fontLightClass(status){
      if(status == "已删除"){
        return 'fRed'
      }
      if(status == "已封禁"){
        return 'fGrey'
      }
      if(status == "审核中"){
        return 'fBlue'
      }
      if(status == "已发布"){
        return 'fGreen'
      }
    }
  }
};
</script>

<style scoped>
.fRed{
  color: red;
}
.fGrey{
  color: #B3C0D1;
}
.fBlue{
  color: deepskyblue;
}
.fGreen{
  color: limegreen;
}

</style>