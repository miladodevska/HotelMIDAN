package com.example.midan.web;

import com.example.midan.model.Employee;
import com.example.midan.model.Enumerations.DepartmentType;
import com.example.midan.model.Room;
import com.example.midan.service.EmployeeService;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final RoomService roomService;

    public EmployeeController(EmployeeService employeeService, RoomService roomService) {
        this.employeeService = employeeService;
        this.roomService = roomService;
    }


    @GetMapping
    public String getEmployeePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Employee> employees = this.employeeService.listAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("bodyContent", "employees");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        this.employeeService.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeePage(@PathVariable Long id, Model model) {
        if (this.employeeService.findById(id) != null) { //? nemase isPresent() -- ne go dava u auto complete, znaci ne mozeme da stavime kje javuva greska
            Employee employee = this.employeeService.findById(id);
            model.addAttribute("bodyContent", "add-employee");
            return "master-template";
        }
        return "redirect:/offers?error=OfferNotFound";
    }

    @GetMapping("/add-form")
    public String addEmployeePage(Model model) {
        List<Room> rooms = this.roomService.listAllRooms();
        model.addAttribute("rooms", rooms);
        model.addAttribute("bodyContent", "add-employee");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveEmployee(
            @RequestParam(required = false) Long id,
            @RequestParam Long embg,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam Integer age,
            @RequestParam String address,
            @RequestParam Integer workExperience,
            @RequestParam DepartmentType department) {
        this.employeeService.save(embg, name, surname, email, phoneNumber, age, address, workExperience, department);
        return "redirect:/employee";
    }
}
