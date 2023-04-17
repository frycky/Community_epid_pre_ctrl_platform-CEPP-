<template>
  <div>
    <el-pagination
        @current-change="currentChange"
        @size-change="sizeChange"
        background
        layout="sizes, prev, pager, next"
        :current-page="currentPage"
        :page-sizes="pageSizes"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "CustomPages",
  props: {
    total: {
      type: [String, Number],
      default: 0
    },
    pageNum: {
      type: [String, Number],
      defaults: 1
    },
    pageSize: {
      type: [String, Number],
      defaults: 10
    },
    pageSizes: {
      Type: Array,
      default: function () {
        return [5, 10, 20, 30]
      }
    },
    currentPage: {
      type: [Number],
      default: 1
    },
  },
  methods: {
    currentChange(e) {
      //自定义事件
      this.$emit("current-change", e)
    },
    sizeChange(e) {
      this.$emit("size-change", e)
    },
  }

}
</script>

<style scoped>

</style>