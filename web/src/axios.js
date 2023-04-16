import axios from "axios"
import router from "@/router";
import Element from "element-ui";

axios.defaults.baseURL = "http://localhost:9999"
axios.defaults.baseURL = process.env.VUE_APP_SERVER

const request = axios.create({
    timeout: 5000,
    headers:{

    }
})

request.interceptors.request.use(config=>{
    config.headers["token"]=localStorage.getItem("token")
    return config
})

request.interceptors.response.use(
    response =>{
        let res = response.data
        if(res.code==200){
            return response.data
        }else {
            //重定向||权限不足
            if(res.code === 301||res.code===401){
                    //跳转到登录页面
                    router.push({path:"/about"})
                    return Promise.reject(res.msg)
            }
            Element.Message.error(!res.msg?"系统异常，请联系管理员":res.msg)
            return Promise.reject(res.msg)
        }
    },
    error => {
        console.log(error)
        return Promise.reject(error)
    }
)
console.log("环境",process.env.NODE_ENV)
console.log("服务器",process.env.VUE_APP_SERVER)
console.log(process.env)

export default request