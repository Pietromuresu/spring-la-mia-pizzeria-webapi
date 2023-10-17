
<script setup>
  import { ref, onMounted } from "vue";
  import store from "../stores/store";
  
  const name = "Home";
  
  
  onMounted(() => {
    store.getPizzas(store.nameParam.value)
  })
</script>

<template>
  <router-view>
    <div class="container">

      <h1>La mia pizzeria</h1>
      <div class="mt-5">
        <div class="d-flex justify-content-between">
          <h2>Menù</h2>
          <div class="btn btn-secondary h-50">
            <router-link @click="store.toUpdate = false, store.cleanForm()" :to="{ name: 'create-update' }" class="text-white text-decoration-none">
              Add new 
			      </router-link>
            
          </div>
        </div>
        <div v-if="store.pizza.value.length > 0" class="row row-cols-4">
          <div  class="col" v-for="pi in store.pizza.value" :key="pi.id">
            <div class="card mt-4">
              <img class="card-img-top" :src="`${store.IMG_BASE_URL + pi.fotoUrl}`" :alt="pi.name">
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
                <router-link @click="store.toUpdate = true, store.fillForm(pi)" :to="{ name: 'create-update' }" class="text-decoration-none">
                  Modify
                </router-link>
                <span @click="store.deletePizza(pi.id)" class="btn btn-danger btn-sm ms-3">Delete</span>
              </div>
            </div>

          </div>
        </div>
        <div v-else class="mt-4">
          <h4 class="text-center">Non ci sono pizze..</h4>
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