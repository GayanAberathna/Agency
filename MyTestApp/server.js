const express = require('express');
const bodyParser= require('body-parser') 
const MongoClient = require('mongodb').MongoClient
const app = express();
var path = require('path')
var _ = require('lodash');
app.use(bodyParser.urlencoded({extended: true}))
app.use(express.static(path.join(__dirname, 'public')));
app.set('view engine', 'ejs')

var db
var trips = [];
MongoClient.connect('mongodb://gayanaberathna:Vijitha123.@ds249873.mlab.com:49873/mytestapp', (err, client) => {
  if (err) return console.log(err)
  db = client.db('mytestapp') // whatever your database name is
  app.listen(3000, () => {
    console.log('listening on 3000')
  })
})

app.get('/', (req, res) => {
  db.collection('trips').find().toArray((err, result) => {
    if (err) return console.log(err)
    // renders index.ejs
    trips = result;
    res.render('index.ejs', {trips: result})
  })
})

app.get('/tour-details', (req, res) => {
  var topic = req.query.topic;
  var pickedTrip = _.find(trips, function(o) { return o.TourName == topic; });
  //console.log(picked);
    res.render('tour-detail.ejs', {pickedTrip});
})
 
  app.post('/quotes', (req, res) => {
    db.collection('quotes').save(req.body, (err, result) => {
      if (err) return console.log(err)
  
      console.log('saved to database')
      res.redirect('/')
    })
  })
 