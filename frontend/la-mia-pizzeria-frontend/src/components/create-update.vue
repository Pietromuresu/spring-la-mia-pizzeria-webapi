
<script setup>
import Header from '../components/Header.vue'
import { ref} from 'vue'
import router from '../router';
import axios from 'axios';
import store from "../stores/store";
  const name = "create-update";

  const error = null;


  function addNew(){
    axios.post(store.API_URL + "add", store.newPizza.value)
          .then(res =>{
            console.log(res.data);
            router.push({ path: '/' })
          })
          .catch(error => this.error = error);
  };

  function updateNew(id){
    axios.put(store.API_URL + "update/" + id, store.newPizza.value)
          .then(res =>{
            console.log(store.newPizza.value.id);
            console.log(res.data);
            router.push({ path: '/' })
          })
          .catch(error => this.error = error);
  };

</script>

<template>
  <router-view>
    <Header />
    <div class="container w-25">

      <h1>Aggiungi pizza</h1>
      <form @submit.prevent="`${!store.toUpdate  ? addNew() : updateNew(store.newPizza.value.id)}`">
        <div class="input-box mt-5 ">
          <label for="description" class="form-label"><strong> Nome </strong> </label>
          <input
            v-model="store.newPizza.value.name"
            class="form-control "
            type="text"
            placeholder="Es. Margherita"> <br>
          <div v-if="error">
            ERROR
          </div>  
        </div>
        <div class="input-box">
          <label for="description" class="form-label"><strong> Descrizione </strong> </label>
          <textarea
            v-model="store.newPizza.value.description"
            class=" form-control "
            type="text"
            placeholder="Es. nuovissima pizza "></textarea> <br>
          <div v-if="error">
            ERROR
          </div>  
        </div>
        <div class="input-box">
          <label for="description" class="form-label"><strong> Prezzo </strong> </label>
        <input
            v-model="store.newPizza.value.price"
            class=" form-control "
            type="float"
            placeholder="Es. 3,50 &euro;"> <br>
          <div v-if="error">
            ERROR
          </div>  
        </div>
        <div class="input-box">
          <label for="description" class="form-label"><strong> Foto URL </strong> </label>
        <input
            v-model="store.newPizza.value.fotoUrl"
            class=" form-control "
            type="text"
            placeholder="img.jpeg"> <br>
          <div v-if="error">
            ERROR
          </div>  
        </div>
        <!-- <div class="input-box ">
          <h5>Ingredienti</h5>
          <form>
            <input
              v-model="store.newPizza.value.ingredients"
              id="mozz"
              type="checkbox"
              placeholder="Nome">
            <label for="mozz" class="form-label"><strong> Mozz </strong> </label>
          </form>
        </div> -->
        <button v-if="!store.toUpdate" type="submit" class="btn btn-secondary mt-5">
          Save
        </button>
        <button v-else type="submit" class="btn btn-secondary mt-5">
          Update
        </button>

      </form>
    </div>
  </router-view>
</template>

<style scoped>

</style>