var mongoose = require("mongoose");

var hotelSchema = mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  stars: {
    type: Number,
    min: 0,
    max: 5,
    required: true
  },
  rooms: {
    type: Number,
    required: true,
    min: 1
  }
});
var hotel = mongoose.model("Hotel", hotelSchema);
module.exports = hotel;
