import express from 'express'
import routes from './src/routes/patientRoutes'
import mongoose from 'mongoose'
import bodyParser from 'body-parser'

const app = express();
const PORT = 40000;

//Mongoose connection
mongoose.Promise=global.Promise  //this means that we are going to wait for result when we are connecting to mongo db
mongoose.connect('mongodb://localhost/PatientsDB',
{
    useNewUrlParser : true,
    useUnifiedTopology: true
});

//body parser setup
app.use(bodyParser.urlencoded({extended:true}));
app.use(bodyParser.json());


routes(app);

app.get( '/',(req,res) => res.send(`Node and express running at port ${PORT}`));

app.listen(PORT,() => 
console.log(`server is running at port ${PORT}`));