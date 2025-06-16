<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Budget App</title>
 <link
      rel="shortcut icon"
      href="images/paysave.png"
      type="image/x-icon"
    />
 <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body>
<main>

<!--hero-page-end  -->
<!--hero-page-start-->
<section class="min-h-screen bg-gradient-to-b from-[#b3b3ff] via-[#5c5cff] to-[#2c00f0] text-white">
  <!-- Header -->
  <header class="absolute inset-x-0 top-0 z-10 w-full">
    <div class="px-4 mx-auto sm:px-6 lg:px-8">
      <div class="flex items-center justify-between h-16 lg:h-20">
        <!-- Logo -->
        <div class="flex-shrink-0">
          <a href="#" class="flex">
            <img src="images/paysavelogo.png" class="h-6" alt="PaySave Logo">
          </a>
        </div>

        <!-- Mobile menu button -->
        <button type="button" class="inline-flex items-center p-2 text-sm text-white uppercase transition-all duration-200 bg-black lg:hidden hover:bg-gray-800">
          <svg class="w-6 h-6 mr-2" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
          </svg>
          Menu
        </button>

        <!-- Nav -->
        <div class="hidden lg:flex lg:items-center lg:space-x-10">
          <a href="#" class="text-base hover:text-opacity-80">Features</a>
          <a href="#" class="text-base hover:text-opacity-80">Solutions</a>
          <a href="#" class="text-base hover:text-opacity-80">Resources</a>
          <a href="#" class="text-base hover:text-opacity-80">Pricing</a>
        </div>

        <a href="login.jsp" class="hidden lg:inline-flex items-center justify-center px-5 py-2.5 text-base font-semibold border-2 border-white hover:bg-white hover:text-[#2c00f0] transition-all duration-200">
          Try for free
        </a>
      </div>
    </div>
  </header>

  <!-- Hero Content -->
  <div class="flex items-center justify-between px-6 pt-32 pb-16 lg:px-20">
    <!-- Left: Text -->
    <div class="w-full max-w-xl">
      <h1 class="text-4xl font-bold sm:text-6xl xl:text-7xl leading-tight">
        Take control<br />on your daily expenses
      </h1>
      <p class="mt-6 text-lg sm:text-xl">Our PaySave helps you to predict your expenses based on your previous activity and shares how you should manage your money.</p>
      <a href="registration.jsp" class="inline-block px-6 py-5 mt-8 text-base font-semibold text-[#2c00f0] bg-white hover:bg-gray-100 transition-all duration-200">
        Get started for free
      </a>

      <!-- App Store Buttons -->
      <div class="mt-12">
        <p class="text-base font-semibold">App available on</p>
        <div class="flex items-center space-x-5 mt-4">
          <a href="#"><img class="h-14 rounded hover:opacity-80" src="https://cdn.rareblocks.xyz/collection/celebration/images/hero/4/app-store-button.png" alt="App Store" /></a>
          <a href="#"><img class="h-14 rounded hover:opacity-80" src="https://cdn.rareblocks.xyz/collection/celebration/images/hero/4/play-store-button.png" alt="Play Store" /></a>
        </div>
      </div>
    </div>

    <!-- Right: Image -->
    <div class="hidden lg:block lg:w-[500px]">
      <img src="https://cdn.rareblocks.xyz/collection/celebration/images/hero/4/phone-mockup.png" alt="App Mockup" class="w-full h-auto" />
    </div>
  </div>
</section>
<!--hero-page-end-->


<!--hero-page-end-->










</main>








</body>
</html>