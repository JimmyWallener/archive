import config from '../config/config.js';

export const getKeywordBasedData = async (keyword) => {
  const url = `https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=${config['flickr-key']}&text=${keyword}&sort=relevance&safe_search=1&accuracy=1&content_type=1&format=json&nojsoncallback=1`;
  let response = await fetch(url);
  return response.json();
};

export const getImageUri = (photo, size) =>
  `https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_${size}.jpg`;

export default {
  getKeywordBasedData,
  getImageUri,
};
