import { ref} from 'vue'
import axios from 'axios';
export default{
  API_URL : "http://localhost:8080/api/v1.0/",
  IMG_BASE_URL : "http://localhost:8080/imgs/",

  toUpdate: false,

  fillForm(pizza){
    
      this.newPizza.value.name= pizza.name;
      this.newPizza.value.description= pizza.description;
      this.newPizza.value.fotoUrl= pizza.fotoUrl;
      this.newPizza.value.price= pizza.price;

  },
  cleanForm(){
    
      this.newPizza.value.name= null;
      this.newPizza.value.description= null;
      this.newPizza.value.fotoUrl= null;
      this.newPizza.value.price= null;

  },

  newPizza : ref({
    name: null,
    description: null,
    fotoUrl: null,
    price: null,
  }),

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
          console.log("ciao");

  },

  deletePizza(id){
    axios.delete(this.API_URL + "delete/" + id)
      .then(()=>{
        this.getPizzas("")
      })
      .catch(error => console.log(error))

    
    
  },

  addNew(){
    axios.get
    axios.post(this.API_URL + "add",  this.newPizza.value)
    .then(() =>{
      
          })
          .catch(error => this.error = error)
  }


}