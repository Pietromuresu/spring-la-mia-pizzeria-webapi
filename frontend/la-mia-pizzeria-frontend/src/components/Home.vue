
<script setup>
  import { ref, onMounted } from "vue";
  import axios from 'axios'
  const name = "Home";
  const API_URL = "http://localhost:8080/api/v1.0/";
  const IMG_BASE_URL = "http://localhost:8080/imgs/";

  let pizza = ref([]);

  async function getAllPizzas(){
    axios.get(API_URL + "all")
          .then(res => {
            const data = res.data;
            pizza.value = data;
          })
          .catch(err => console.log(err));
  }
  

  onMounted(() => {
    getAllPizzas()
  })
</script>

<template>
  <router-view>
    <div class="container">

      <h1>La mia pizzeria</h1>
      <div class="mt-5">
        <div class="d-flex justify-content-between">
          <h2>Menù</h2>
          <div class="btn btn-secondary h-50">Add new </div>
        </div>
        <div v-show="pizza != null" class="row row-cols-4">
          <div  class="col" v-for="pi in pizza" :key="pi.id">
            <div class="card mt-4">
              <img class="card-img-top" :src="`${IMG_BASE_URL + pi.fotoUrl}`" :alt="pi.name">
              <div class="card-body">
                <h5 class="card-title">{{  pi.name  }}</h5>
                <p class="card-text">{{pi.description }}</p>
              </div>
              <ul class="list-group list-group-flush">
                <li v-for="i in pi.ingredients" :key="i.id" class="list-group-item">{{ i.name }}</li>  
              </ul>
              <div>
                <h5 class="card-text p-3">Price: {{pi.price}} &euro;</h5>
              </div>
              <div class="card-body">
                <a href="#" class="card-link">Modify </a>
                <a href="#" class="card-link">Delete</a>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
      
      
  </router-view>
</template>
<style scoped>
.card-img-top{
  height: 200px;
}
</style>