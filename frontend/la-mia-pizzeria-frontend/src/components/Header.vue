<script setup>
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
				
		    <form 
        onsubmit=""
		    	class="d-flex form-inline" 
		    	role="search" >
		    	
		      <input 
		      	class="form-control me-2" 
		      	type="text" 
		      	placeholder="Search a pizza" 
		      	aria-label="Search" 
		      	name="name" 
		      	th:value="${searchedName}">
		      
		      <button 
		      	class="btn btn-outline-secondary" 
		      	type="submit">
		      	Search
		      </button>
		    
		    </form>
			
			
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