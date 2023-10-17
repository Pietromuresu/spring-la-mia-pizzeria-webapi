import { ref} from 'vue'
import axios from 'axios';
export default{
  API_URL : "http://localhost:8080/api/v1.0/",
  IMG_BASE_URL : "http://localhost:8080/imgs/",


  pizza : ref([]),
  nameParam : ref(""),

  getPizzas(name){
    axios.get(this.API_URL + "all", {
      params:{
        name: name
      }
    })
          .then(res => {
            const data = res.data;
            this.pizza.value = data;
          })
          .catch(err => console.log(err));

      return this.pizza
  },



}