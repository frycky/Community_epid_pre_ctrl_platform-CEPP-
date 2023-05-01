//定义混入

const create = {
    data() {
        return {
            //api路径
            api: {
                pageUrl: "",
                saveUrl: "",
                delUrl:"",
            },
            //抽屉控制
            isDrawerDialog: false,
            //列表数据
            tableData: [],
            //分页详情
            pageInfo: {
                //当前页
                pageNum: 1,
                //分页大小
                pageSize: 10,
                //总条数
                total: 0,
            },
            //搜索参数
            searchForm: {
                title: "",
                username:"",
            },
            //删除的id
            ids: [],
            //新增
            formData: {
                id: null,
                title: "",
                username:"",
                password:"",
                permission:0,
                path:"",
            },
            ruleForm: {
                title: [
                    {required: true, message: '请输入栏目名称', trigger: 'blur'},
                ],
            },
            dialogTableVisible: false,
            id:0,
            currentMenuList:[],
            currentTable:[],

        }
    },
    created() {
        this.getList()
    },
    methods: {
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
        formatDateU(row) {
            if (row.updateTime === null){
                return null
            }
            // 获取单元格数据
            let datedata = row.updateTime
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
        //更新文章栏目信息表格
        getList() {
            let data = Object.assign(this.searchForm, this.pageInfo)
            this.$axios.post(this.api.pageUrl, data).then(res => {
                this.tableData = res.data.list
                this.pageInfo.total = res.data.total
                console.log(res)
            })
        },
        //分页
        currentChange(e) {
            this.pageInfo.pageNum = e
            this.getList()
            console.log(e)
        },
        //改变分页数量
        sizeChange(e) {
            this.pageInfo.pageSize = e
            this.getList()
            console.log(e)
        },
        //搜索
        handleSearch() {
            this.pageInfo.pageNum = 1
            this.getList()
        },
        //自定义关闭事件
        closeDrawer(e) {
            this.isDrawerDialog = e
        },
        //自定义提交事件
        submitDrawer(e) {
            this.$axios.post(this.api.saveUrl, e).then(res => {
                console.log(res)
                if (res.code === 200) {
                    this.isDrawerDialog = false
                    this.$message({
                        message: res.msg,
                        type: 'success'
                    });
                    this.getList()
                }
            })
        },
        //自定义新增事件
        handleAdd() {
            this.isDrawerDialog = true
            this.formData = {}
        },
        //编辑
        handleEdit(index, row) {
            this.isDrawerDialog = true
            console.log(index, row);
            this.formData = Object.assign({}, row)
        },
        //多选操作
        handleSelectionChange(val) {
            console.log(val)
            this.ids = []
            val.forEach(item => {
                this.ids.push(item.id)
            })
        },
        //单个删除
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
                this.$axios.post(this.api.delUrl, this.ids).then(res => {
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
        },
        //菜单管理
        handleChange(id){
            //清空数据
            this.currentTable = []
            this.currentMenuList = []

            this.dialogTableVisible=true
            this.id = id
            this.getByTypeId(this.id)
        },
        submitEdit() {
            let ids = []
            this.currentTable.forEach(item => {
                ids.push(item.id)
            })
            let data = {
                typeId: this.id,
                menuIdList: ids
            }
            console.log(ids)
            this.$axios.post("/user_type/saveTypeAndMenu", data).then((res) => {
                if (res.code === 200) {
                    this.isDrawerDialog = false
                    this.$message({
                        message: res.msg,
                        type: 'success'
                    });
                    this.getList()
                    this.getMenuList()

                }
            })
            this.dialogTableVisible = false
        },
        getMenuList() {
            this.$axios.get("/menu-list/list").then((res) => {
                this.menuList = res.data
            })
        },
        selectionTableChange(e) {
            this.currentTable=e
        },

    }
}

export default create