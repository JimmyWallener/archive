import { getKeywordBasedData, getImageUri } from './api.js';

(function () {
  // Hiding code in IIFE function
  const createGallery = (keyword, size = 'm', count = 10) => {
    // Creating the gallery based on keyword
    getKeywordBasedData(keyword)
      .then((data) => {
        // if status code is 200 (ok), lets check <div> for already existing children, remove them then populate with new children <img> tags
        if (data.stat === 'ok') {
          const container = document.querySelector('.slides');
          while (container.firstChild) {
            container.removeChild(container.lastChild);
          }
          for (let i = 0; i < count; i++) {
            const slide = document.createElement('div');
            container.appendChild(slide);
            slide.setAttribute('class', 'slide fade');
            slide.innerHTML += `
            <img src="${getImageUri(data.photos.photo[i], size)} alt="${
              data.photos.photo[i].title
            }" />
            <p class="text">${data.photos.photo[i].title}</p>
            `;
          }
          // creates the slideshow function by changing display attribute
          let slideIndex = 0;
          const showSlides = (n) => {
            const slides = document.querySelectorAll('.slide');

            if (n > slides.length) {
              slideIndex = 1;
            }
            if (n < 1) {
              slideIndex = slides.length;
            }
            for (let i = 0; i < slides.length; i++) {
              slides[i].style.display = 'none';
            }
            slides[slideIndex - 1].style.display = 'block';
          };
          showSlides(slideIndex);
          // addeventlisterners for controlling back & forth arrows on the slideshow
          const prev = document.querySelector('.prev');
          prev.addEventListener('click', () => showSlides((slideIndex += -1)));

          const next = document.querySelector('.next');
          next.addEventListener('click', () => showSlides((slideIndex += 1)));
        }
      })
      .catch((error) => {
        document.querySelector('.error').innerHTML = error;
      });
  };

  const btn = document.querySelector('#submit');
  const form = document.querySelector('#query');

  // Capturing formdata on submit and using data to create gallery
  btn.addEventListener('click', (e) => {
    e.preventDefault();

    const formData = new FormData(form);

    if (formData.get('keyword') === '') {
      document.querySelector('.error').innerHTML =
        'Hey, missing a keyword to look for there buddy!';
    } else {
      document.querySelector('.error').innerHTML = '';
      createGallery(
        formData.get('keyword'),
        formData.get('size'),
        formData.get('count')
      );
    }
  });
})();
