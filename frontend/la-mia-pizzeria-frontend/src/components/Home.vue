
<script setup>
  import { ref, onMounted } from "vue";
  import axios from 'axios'
  const name = "Home";

  let pizza = ref(null);

  onMounted(() => {
    axios.get("http://localhost:8080/api/v1.0/all")
          .then(res => {
            const data = res.data;
            pizza = data;
          })
  })
</script>

<template>
  <router-view>
    <h1>La mia pizzeria</h1>
    <div class="mt-5">
      <h2>Menù</h2>
      <ul>
        <li v-for="pi in pizza">
          {{ pi.name + " " +pi.price + "$"}}
        </li>
      </ul>
    </div>

  </router-view>
</template>
<style>

</style>