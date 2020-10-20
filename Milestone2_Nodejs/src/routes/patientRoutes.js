import { addNewPatient,getPatient,getPatientWithId,updatePatient,deletePatient,addMedicalHistory, getPatientMedicalHistory} from '../contorllers/patientControllers'

const routes = (app) => 
{
        app.route('/patients')
            .get((req,res,next)=>
            {
                console.log(`Request from : ${req.originalUrl}`)
                console.log(`Request method : ${req.method}`)
                next();
            },
            getPatient)
            .post(addNewPatient),
            

        app.route('/patient/:patientID')
            .get(getPatientWithId)
            .put(updatePatient)  
            .delete(deletePatient),

        app.route('/patients/medicalhistory')
            .post(addMedicalHistory)
            .get(getPatientMedicalHistory)
}

export default routes