// Get the toggle button and navigasi container
const toggleButton = document.querySelector('.topbar .togle');
const navigasi = document.querySelector('.navigasi');
const mainContent = document.querySelector('.main');
// const topbar = document.querySelector('.topbar'); // Ambil elemen topbar


// Add event listener for toggle button
toggleButton.addEventListener('click', () => {
    // Toggle the visibility of the navigasi
    navigasi.classList.toggle('hidden');

    // Adjust the margin of the main content to fill the space left by the navigation
    if (navigasi.classList.contains('hidden')) {
        mainContent.style.marginLeft = '0'; 
        mainContent.style.width = '100%'; 
    } else {
        mainContent.style.marginLeft = '250px'; // Restore margin when navigation is visible
        mainContent.style.width = 'calc(100% - 250px)'; // Restore width when navigation is visible
    }
});
