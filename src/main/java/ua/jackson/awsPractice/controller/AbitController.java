package ua.jackson.awsPractice.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.jackson.awsPractice.dto.AbitDTO;
import ua.jackson.awsPractice.entity.Abiturient;
import ua.jackson.awsPractice.entity.Subject;
import ua.jackson.awsPractice.mail.MailMessageSendRequst;
import ua.jackson.awsPractice.payload.request.UpdateAbitRequest;
import ua.jackson.awsPractice.repository.AbitRepos;
import ua.jackson.awsPractice.repository.FacultyRepo;
import ua.jackson.awsPractice.repository.SpecRepo;
import ua.jackson.awsPractice.service.AbiturientService;
import ua.jackson.awsPractice.service.MailSender;
import ua.jackson.awsPractice.service.UpdateAbitService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class AbitController {

    @Autowired
    FacultyRepo facultyRepo;

    @Autowired
    SpecRepo specRepo;

    @Autowired
    private AbitRepos abitRepos;

    @Autowired
    private AbiturientService abitS;

    @Autowired
    UpdateAbitService updateAbitService;

    @GetMapping(value = "/allAA")
    public List<Abiturient> allADD(){
        return abitS.getAllAbits();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/addAbit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addedAbitur(@RequestBody UpdateAbitRequest updateAbitRequest){

        System.out.println();
        System.out.println("ADD ABIT WAS CALLLLLEDEDE");
        System.out.println();

        this.updateAbitService.updateAbbit(updateAbitRequest);
        System.out.println(updateAbitRequest.toString());
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(value = "/allAb")
    public List<Abiturient> allAbitsFullInfo(){
        return abitRepos.findAll();
    }

    @GetMapping("/max")
    public Abiturient maxAVG() {
        return abitS.abitWithMaxAvgMark();
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getById/{id}")
    public AbitDTO getOne(@PathVariable Long id) {
        Abiturient one = this.abitRepos.getOne(id);



    /*    System.out.println("one.getSpecializations().size() " +one.getSpecializations().size());
        System.out.println("one.getSpecializations().size() " +abiturient.getSpecializations().size());

        abiturient.setSpecializations(one.getSpecializations());

        System.out.println();

        System.out.println("one.getSpecializations().size() " +one.getSpecializations().size());
        System.out.println("one.getSpecializations().size() " +abiturient.getSpecializations().size());

*/

        System.out.println(new AbitDTO(
                one.getIdAbitCode(),
                one.getSurname(),
                one.getPoBatkovi(),
                one.getAvgDiplomaMark(),
                one.getFaculties(),
                one.getRequestCounter(),
                one.getSubjs(),
                one.getSpecializations()));
        System.out.println("INSIDE");

        return new AbitDTO(
                one.getIdAbitCode(),
                one.getSurname(),
                one.getPoBatkovi(),
                one.getAvgDiplomaMark(),
                one.getFaculties(),
                one.getRequestCounter(),
                one.getSubjs(),
                one.getSpecializations());
    }

    @DeleteMapping("/del/{id}")
    public void deleteById(@PathVariable Long id){
        Abiturient one = abitRepos.getOne(id);

        one.setFaculties(null);

//        List<Faculty> faculties = one.getFaculties();
//        faculties.forEach(e -> e.getSpecializations().forEach(q-> q.se specRepo.delete(q)));
//        faculties.forEach(faculty -> facultyRepo.delete(faculty));

        abitRepos.delete(one);

    }


//    @GetMapping(value = "/asd", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
//    public FacultyDto allAbitsList(){

//        FacultyDto facultyDto = new FacultyDto();
//        Set<Abiturient> abiturients = new HashSet<>(abitRepos.findAll());
//        facultyDto.setAbiturients(abiturients);
//
//        return facultyDto;
//    }

    @GetMapping(value = "/max/{subject}", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public List<Abiturient> maxBySubject(@PathVariable Subject subject){
        return  abitS.abitWithGreaterMark(subject,"");
    }



  /*  @GetMapping("/allAbPa")
    public ResponseEntity<Page<Abiturient>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Abiturient> list =  abitRepos.findAll(paging);

        return new ResponseEntity<List<Abiturient>>(list, new HttpHeaders(), HttpStatus.OK);
    }*/

    @GetMapping("/save")
    public void  saveAbit(@RequestBody Abiturient abiturient){
        System.out.println(abiturient);
        this.abitRepos.save(abiturient);
    }

    @Autowired
    MailSender mailSender;

//    @Autowired
//    SendEmail sendEmail;

    @PostMapping("/send")
    public void sendMessage(@RequestBody MailMessageSendRequst mailMessageSendRequst ){
        mailSender.sendSimpleMessage(
                mailMessageSendRequst.getTo(),
                mailMessageSendRequst.getSubject(),
                mailMessageSendRequst.getText());
        System.out.println("Message was sended");
    }



    @GetMapping("/par")
    public void parse() throws IOException {

        String url = "http://idtd.nltu.edu.ua/ua/news/list";
        Document doc = Jsoup.connect(url).get();
        doc.select("a").forEach(System.out::println);

        System.out.println();
        System.out.println("---------");
        System.out.println();

        Document doc2 = Jsoup.connect(url).get();
        System.out.println(doc2.body());

//        doc.select("<a>")
        Elements select = doc.select("a[href]");
        System.out.println(select);
            Map<String,String> aa = new HashMap<>();
//            aa.compute("aa","aaa");
    }


}
