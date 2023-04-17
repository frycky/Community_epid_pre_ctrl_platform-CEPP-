<!--<template>-->
<!--  <div>-->
<!--    <div class="pb10px">-->
<!--      &lt;!&ndash;@input="handleSearch"与@click="handleSearch"相绑定，实现输入即搜索&ndash;&gt;-->
<!--      <el-input v-model="searchForm.title" @input="handleSearch" class="input" clearable placeholder="请输入标题" size="small"></el-input>-->
<!--      <el-button type="primary" icon="el-icon-search" size="small" class="mr10px" @click="handleSearch">搜索</el-button>-->
<!--    </div>-->
<!--    <div>-->
<!--      <el-button @click="handleAdd" type="primary" size="small">新增</el-button>-->
<!--      <el-button size="small" type="danger" @click="batchDelete" :disabled="ids.length>0 ? false : true">批量删除</el-button>-->
<!--    </div>-->

<!--    <el-table-->
<!--        ref="multipleTable"-->
<!--        :data="tableData"-->
<!--        tooltip-effect="dark"-->
<!--        style="width: 100%"-->
<!--        @selection-change="handleSelectionChange">-->
<!--      <el-table-column-->
<!--          type="selection"-->
<!--          width="55">-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--          prop="id"-->
<!--          label="ID"-->
<!--          width="50">-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--          prop="createTime"-->
<!--          label="发布时间"-->
<!--          width="170"-->
<!--          :formatter="formatDateC">-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--          prop="title"-->
<!--          label="标题"-->
<!--          show-overflow-tooltip>-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--          prop="username"-->
<!--          label="用户"-->
<!--          show-overflow-tooltip>-->
<!--      </el-table-column>-->
<!--      <el-table-column-->
<!--          prop="statusType"-->
<!--          label="状态"-->
<!--          show-overflow-tooltip>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="操作">-->
<!--        <template slot-scope="scope">-->
<!--          <el-button-->
<!--              size="mini"-->
<!--              @click="handleEdit(scope.$index, scope.row)">编辑-->
<!--          </el-button>-->
<!--          <el-button-->
<!--              size="mini"-->
<!--              type="danger"-->
<!--              @click="handleDelete(scope.$index, scope.row)">删除-->
<!--          </el-button>-->
<!--        </template>-->
<!--      </el-table-column>-->
<!--    </el-table>-->
<!--    -->
<!--    &lt;!&ndash;分页组件&ndash;&gt;-->
<!--    <CustomPages-->
<!--        @current-change="currentChange"-->
<!--        @size-change="sizeChange"-->
<!--        :total="pageInfo.total"-->
<!--        background-->
<!--        layout="sizes, prev, pager, next"-->
<!--        :page-sizes="[5,10,20,30]"-->
<!--        :current-page="pageInfo.pageNum"-->
<!--    >-->
<!--    </CustomPages>-->

<!--    &lt;!&ndash;抽屉组件&ndash;&gt;-->
<!--    <CustomDrawer-->
<!--        :form-data="formData"-->
<!--        :rules-form="ruleForm"-->
<!--        @close-drawer="closeDrawer"-->
<!--        @submit-drawer="submitDrawer"-->
<!--        :is-drawer-dialog="isDrawerDialog"-->
<!--    >-->
<!--      <div slot="content">-->
<!--        <el-form-item label="栏目：" prop="title">-->
<!--          <el-input v-model="formData.title" placeholder="请输入内容"></el-input>-->
<!--        </el-form-item>-->
<!--      </div>-->
<!--    </CustomDrawer>-->


<!--  </div>-->

<!--</template>-->

<!--<script>-->
<!--import create from "@/mixins/create";-->

<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      api:{-->
<!--        artUrl:"/word-info/pageTitle",-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  mixins: [create],-->
<!--  methods: {-->

<!--  }-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->
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
          prop="username"
          label="用户"
          show-overflow-tooltip>
      </el-table-column>
      <el-table-column
          prop="statusType"
          label="状态"
          show-overflow-tooltip>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">详情
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
};
</script>

<style scoped>

</style>