
	var http = require("http");
	var express = require('express');
	var app = express();
	var mysql      = require('mysql');
	var bodyParser = require('body-parser');


var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database : 'carrent',
});
 
 
connection.connect(function(err) {
  if (err) throw err
  console.log('You are now connected with mysql database...')
})



app.use( bodyParser.json() );       // to support JSON-encoded bodies
app.use(bodyParser.urlencoded({     // to support URL-encoded bodies
  extended: true
}));



var server = app.listen(3000, "127.0.0.1", function () {

  var host = server.address().address
  var port = server.address().port

  console.log("Example app listening at http://%s:%s", host, port)

});


//rest api to get all users
app.get('/users', function (req, res) {
   connection.query('select id,user_name,email,phone,address from users', function (error, results, fields) {
	  if (error) throw error;
	  res.end(JSON.stringify(results));
	});
});


app.get('/cars', function (req, res) {
   connection.query('select id,brand,type,model,year,color,licence,state from car_model', function (error, results, fields) {
	  if (error) throw error;
	  res.end(JSON.stringify(results));
	});
});


//rest api to get a single user data
// app.get('/user/:id', function (req, res) {
//    connection.query('select id,user_name,email,phone,address from users where Id=?', [req.params.id], function (error, results, fields) {
// 	  if (error) throw error;
// 	  res.end(JSON.stringify(results));
// 	});
// });