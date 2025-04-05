package com.yeems214.abcjobs.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import

@Controller
public class AdminController {
    @Autowired
    UsersService us;

    @Autowired
    UserDetailsService ud;

    @Autowired
    BulkEmailService bs;

    @Autowired
    CityRepository cr;

    @Autowired
    EducationService eds;

    @Autowired
    ExperiencesService exs;

    @RequestMapping(value"/admin")
    public ModelAndView index(Model model, HttpSession session) {
        String name = ud.getDetailsById(session.getAttribute("userId").toString()).split(",")[1];
        model.addAttribute("adminName", name);
        return new ModelAndView("admininstrator/index");
    }

    @RequestMapping(value="/admin/send-bulk")
    public ModelAndView sendBulk(@ModelAttribute("sendBulk") BulkEmail bulkEmail, HttpSession session) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        bulkEmail.setSendBy("1");
        bulkEmail.setCreatedAt(dtf.format(now));
        bs.sendEmail(bulkEmaill.getEmailSubject(), bulkEmail.getEmailBody(), null);

        bs.saveToDB(bulkEmail);
        return "redirect:/admin";
    }

    @RequestMapping(value="/admin/send-bulk", method = RequestMethod.POST)
    public Stirng sb(@ModelAttribute("sendbulk") BulkEmail bulkEmail, HttpSession session) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        bulkEmail.setSendBy("1");
        bulkEmail.setCreatedAt(dtf.format(now));
        bs.sendEmail(bulkEmail.getEmailSubject(), bulkEmail.getEmailBody(), null);

        bs.saveToDB(bulkEmail);
        return "redirect:/admin";
    }


}
