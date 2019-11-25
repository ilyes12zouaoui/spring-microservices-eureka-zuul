var express = require("express");

var hotels = require("./routes/hotels");

var mongoose = require("mongoose");
const url = "mongodb://localhost:27017/spring";
mongoose.connect(url, { useNewUrlParser: true });
var mongo = mongoose.connection;
mongo.on("connected", () => {
  console.log("ouvrir / initialiser connexion");
});
mongo.on("open", () => {
  console.log("connexion etablie");
});
mongo.on("error", err => {
  console.log(err);
});
var app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: false }));
// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));

app.use("/hotels", hotels);

// // catch 404 and forward to error handler
// app.use(function(req, res, next) {
//   var err = new Error("Not Found");
//   err.status = 404;
//   next(err);
// });

// // error handler
// app.use(function(err, req, res, next) {
//   // set locals, only providing error in development
//   res.locals.message = err.message;
//   res.locals.error = req.app.get("env") === "development" ? err : {};

//   // render the error page
//   res.status(err.status || 500);
//   res.send("error");
// });

app.listen(5000, console.log("listening 5000 .."));
