<script setup>
	import store from "../stores/store"

  const name = "Header";
</script>

<template>
  <nav 
		class="navbar bg-body-tertiary ">
	  <div 
	  	class="container-fluid">
		
		<div>
			<a 
				href="/" 
				class="navbar-brand">
				Home
			</a>
			
		</div>
		<div class="d-flex">	
					
		      <input 
						v-model.trim="store.nameParam.value"
		      	class="form-control me-2" 
		      	type="text" 
		      	placeholder="Search a pizza" 
		      	aria-label="Search" 
		      	name="name" 
		      	th:value="${searchedName}">
		      
		      <button 
					@click="store.getPizzas(store.nameParam.value)"
		      	class="btn btn-outline-secondary" 
		      	type="submit">
		      	Search
		      </button>
			
			
		</div>
	  </div>
	</nav>
</template>

<style scoped>
.navbar{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 100;
}
</style>