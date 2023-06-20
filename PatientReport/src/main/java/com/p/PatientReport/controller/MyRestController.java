/*
 * package com.p.PatientReport.controller;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.p.PatientReport.Model.DiseaseDetail; import
 * com.p.PatientReport.repository.DiseaseRepository;
 * 
 * @RestController public class MyRestController {
 * 
 * @Autowired private DiseaseRepository dr;
 * 
 * @RequestMapping(path = "/getDName",method =RequestMethod.GET) public String
 * fetchDoctorName(@RequestParam("id") Long id) { DiseaseDetail findByDiseaseId
 * = dr.findByDiseaseId(id);
 * System.out.println(findByDiseaseId.getDoctor_name()); return
 * findByDiseaseId.getDoctor_name(); } }
 */