<template>
  <div>
    <div class="pb10px">
      <!--@input="handleSearch"与@click="handleSearch"相绑定，实现输入即搜索-->
      <el-input v-model="search.title" @input="handleSearch" class="input" clearable placeholder="请输入标题" size="small"></el-input>
      <el-button type="primary" icon="el-icon-search" size="small" class="mr10px" @click="handleSearch">搜索</el-button>
    </div>
    <div>
      <el-button @click="drawer = true" type="primary" size="small">新增</el-button>
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
          prop="statusType"
          label="状态"
          show-overflow-tooltip>
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


    <!--分页组件-->
    <!--        :page-size="pageInfo.pageSize"-->
    <el-pagination
        @current-change="currentChange"
        @size-change="sizeChange"
        background
        layout="sizes, prev, pager, next"
        :page-sizes="[5,10,20,30]"
        :current-page="pageInfo.pageNum"
        :total="pageInfo.total">
    </el-pagination>

    <!--抽屉组件-->
    <el-drawer
        :title="formData.id==null?'新增':'编辑'"
        :visible.sync="drawer"
        :direction="direction"
        :wrapper-closable="false"
        :before-close="handleClose"
    >
      <el-input v-model="formData.title" placeholder="请输入内容"></el-input>
      <el-button type="primary" @click="submitData" style="padding-left: 20px;margin: 10px">提交</el-button>
      <el-button type="danger" @click="cancel" style="padding-left: 20px ;margin: 10px">取消</el-button>
    </el-drawer>


  </div>

</template>

<script>
export default {
  data() {
    return {
      text: "",
      tableData: [
        {
          createTime: "2023-4-16",
          title: "这里是标题",
          statusType: "正常",
        },
        {
          createTime: "",
          title: "",
          statusType: "",
        },
      ],
      drawer: false,
      direction: 'btt',
      formData: {
        id: null,
        title: "",//新增
      },
      ids: [],//删除的id
      pageInfo: {
        pageNum: 1,
        pageSize: 10,
        total: 0,//数组总条数
      },
      search: {
        title: ""
      },
    }
  },
  created() {
    this.getList()
  },
  methods: {
    //更新文章栏目信息表格
    getList() {
      let data = Object.assign(this.search, this.pageInfo)
      this.$axios.post("/word-info/pageTitle", data).then(res => {
        this.tableData = res.data.list
        this.pageInfo.total = res.data.total
        console.log(res)
      })
    },
    //格式化日期
    formatDateC(row) {
      // 获取单元格数据
      let datedata = row.createTime
      let dtc = new Date(datedata)
      //获取月,默认月份从0开始
      let dtuMonth = dtc.getMonth() + 1
      //获取日
      let dtuDay = dtc.getDate()
      //处理1-9月前面加0
      if (dtuMonth < 10) {
        dtuMonth = "0" + (dtc.getMonth() + 1)
      }
      //处理1-9天前面加0
      if (dtuDay < 10) {
        dtuDay = "0" + dtc.getDate()
      }
      //获取小时
      let dtuHours = dtc.getHours()
      //处理1-9时前面加0
      if (dtuHours < 10) {
        dtuHours = "0" + dtc.getHours()
      }
      //获取分钟
      let dtuMinutes = dtc.getMinutes()
      //处理1-9分前面加0
      if (dtuMinutes < 10) {
        dtuMinutes = "0" + dtc.getMinutes()
      }
      //获取秒
      let dtuSeconds = dtc.getSeconds()
      //处理1-9秒前面加0
      if (dtuSeconds < 10) {
        dtuSeconds = "0" + dtc.getSeconds()
      }
      //组装年月日时分秒,按自己的要求来
      return dtc.getFullYear() + "/" + dtuMonth + "/" + dtuDay + "  " + dtuHours + ":" + dtuMinutes + ":" + dtuSeconds
      //+ " " + dtuHours + ":" + dtuMinutes + ":" + dtuSeconds
    },
    //抽屉栏关闭
    handleClose() {
      // this.$confirm('确认关闭？')
      //     .then(_ => {
      //       done();
      //     })
      //     .catch(_ => {});
      this.drawer = false
    },
    //提交
    submitData() {
      this.$axios.post("/word-info/saveTitle", this.formData).then(res => {
        console.log(res)
        if (res.code === 200) {
          this.formData = {}
          this.drawer = false

          this.$message({
            message: res.msg,
            type: 'success'
          });
          this.getList()
        }
      })
    },
    //取消
    cancel() {
      this.formData = {}
      this.drawer = false
    },
    //分页
    currentChange(e) {
      this.pageInfo.pageNum = e
      this.getList()
      console.log(e)
    },
    sizeChange(e) {
      this.pageInfo.pageSize = e
      this.getList()
      console.log(e)
    },
    //搜索
    handleSearch() {
      this.getList()
    },
    handleSelectionChange(val) {
      console.log(val)
      this.ids = []
      val.forEach(item => {
        this.ids.push(item.id)
      })

    },
    handleEdit(index, row) {
      this.drawer = true
      console.log(index, row);
      this.formData = Object.assign({}, row)
    },
    handleDelete(index, row) {
      console.log(index, row);
      this.ids = [row.id]
      this.batchDelete()
    },
    //批量删除
    batchDelete() {
      this.$confirm('此操作將永久删除所选内容，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        center: true
      }).then(() => {
        //批量删除列表
        this.$axios.post("/word-info/deleteTitle", this.ids).then(res => {
          if (res.code === 200) {
            this.$message({
              message: res.msg,
              type: 'success'
            });
            this.getList()
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消'
        });
        this.$refs.multipleTable.clearSelection();
      });
    }
  }
};
</script>

<style scoped>

</style>