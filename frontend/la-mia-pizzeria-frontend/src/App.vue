<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Header from './components/Header.vue';
</script>

<template>
    <Header />

    <main class="main">
      
      <router-view />
    
    </main>
</template>

<style scoped>
.main{
  margin-top: 60px;
}
</style>
