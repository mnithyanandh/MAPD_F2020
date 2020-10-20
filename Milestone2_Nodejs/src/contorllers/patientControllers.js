import mongoose from'mongoose';
import {addNewPatientSchema,addPatientMedicalHistorySchema} from '../models/patientModels';

const Patient = mongoose.model('Patient',addNewPatientSchema);
const MedicalHistory = mongoose.model('MedicalHistory',addPatientMedicalHistorySchema);

export const addNewPatient = (req,res) => 
{
    let newPatient = new Patient(req.body)
    newPatient.save((err,patient)=>
    {
        if(err)
        {
            res.send(err);
        }
        res.json(patient);
    });
}

export const getPatient = (req,res) => 
{
    Patient.find({},(err,patient)=>
        {
            if(err)
            {
                res.send(err);
            }
            res.json(patient);
        });  
}

export const getPatientWithId = (req,res) => 
{
    Patient.findById(req.params.patientID,(err,patient)=>
        {
            if(err)
            {
                res.send(err);
            }
            res.json(patient);
        });  
}

export const updatePatient= (req,res) => 
{
    Patient.findOneAndUpdate({_id:req.params.patientID},req.body,{new:true , useFindAndModify:false},(err,patient)=>
        {
            if(err)
            {
                res.send(err);
            }
            res.json(patient);
        });  
}

export const deletePatient = (req,res) => 
{
    Patient.remove({_id:req.params.patientID},(err,patient)=>
        {
            if(err)
            {
                res.send(err);
            }
            res.json({message :'Successfully deleted patient record'});
        });  
}

export const addMedicalHistory = (req,res) => 
{
    let newHistory = new MedicalHistory(req.body)
    newHistory.save((err,patient)=>
    {
        if(err)
        {
            res.send(err);
        }
        res.json(patient);
    });
}

export const getPatientMedicalHistory = (req,res) => 
{
    MedicalHistory.find({},(err,patient)=>
        {
            if(err)
            {
                res.send(err);
            }
            res.json(patient);
        });  
}