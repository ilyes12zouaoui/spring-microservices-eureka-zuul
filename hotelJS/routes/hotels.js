var express = require("express");
var router = express.Router();
var mongoose = require("mongoose");
var Hotel = require("../model/Hotel");

router.get("/aa", function(req, res, next) {
  res.send("aaaa");
});

//*******Affichage *********
router.get("/", function(req, res, next) {
  Hotel.find({})
    .then(data => {
      /*res.statusCode = 200;
        res.setHeader('Content-Type','application/json')
        res.json(data);*/
      res.send(data);
    })
    .catch(err => {
      console.log(err);
    });
});
//*******Ajout *********

router.post("/", (req, res, next) => {
  let hotel = new Hotel();
  console.log("aaa0,", req.body);
  hotel.name = req.body.name;
  hotel.stars = req.body.stars;
  hotel.rooms = req.body.rooms;
  hotel.save(err => {
    if (err) {
      console.log(err);
      return;
    } else {
      res.send("created");
    }
  });
});
//*******Supprimer *********
router.delete("/:id", (req, res, next) => {
  let query = { _id: req.params.id };
  Hotel.remove(query, err => {
    if (err) {
      return next(err);
    } else {
      res.send("deleted");
    }
  });
});
//************** Mise a jour *************

router.put("/:id", (req, res) => {
  let hotel = {};
  let query = { _id: req.params.id };
  hotel.name = req.body.name;
  hotel.stars = req.body.stars;
  hotel.rooms = req.body.rooms;
  Hotel.update(query, hotel, err => {
    if (err) {
      console.log(err);
      return;
    } else {
      res.send("updated");
    }
  });
});
module.exports = router;
