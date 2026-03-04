package com.smartcampus.campusissue.controller;

import com.smartcampus.campusissue.model.Issue;
import com.smartcampus.campusissue.repository.IssueRepository;
import com.smartcampus.campusissue.service.MLService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private MLService mlService;

    @Autowired
    private IssueRepository issueRepository;

    @GetMapping("/create")
    public Issue createIssue(@RequestParam String description,
                             @RequestParam String severity,
                             @RequestParam String location) {

        String prediction = mlService.getPrediction(description, severity);

        System.out.println("ML Output: " + prediction);

        // simple JSON parsing
        String category = prediction.split("\"category\": \"")[1].split("\"")[0];
        String priority = prediction.split("\"priority\": \"")[1].split("\"")[0];
        double predictedTime = Double.parseDouble(
                prediction.split("\"predictedResolutionTimeHours\": ")[1]
                        .replace("}", "")
        );

        Issue issue = new Issue();
        issue.setDescription(description);
        issue.setSeverity(severity);
        issue.setCategory(category);
        issue.setPriority(priority);
        issue.setPredictedResolutionTimeHours(predictedTime);
        issue.setStatus("Pending");
        issue.setLocation(location);

        return issueRepository.save(issue);
    }
    @GetMapping("/all")
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
    
    @PutMapping("/updateStatus/{id}")
    public Issue updateStatus(@PathVariable String id,
                              @RequestParam String status) {

        Issue issue = issueRepository.findById(id).orElse(null);

        if(issue != null){
            issue.setStatus(status);
            return issueRepository.save(issue);
        }

        return null;
    }
    
    @GetMapping("/stats")
    public Map<String, Object> getStats() {

        List<Issue> issues = issueRepository.findAll();

        Map<String,Integer> categoryCount = new HashMap<>();
        Map<String,Integer> priorityCount = new HashMap<>();
        Map<String,Integer> statusCount = new HashMap<>();

        for(Issue issue : issues){

            categoryCount.put(
                issue.getCategory(),
                categoryCount.getOrDefault(issue.getCategory(),0)+1
            );

            priorityCount.put(
                issue.getPriority(),
                priorityCount.getOrDefault(issue.getPriority(),0)+1
            );

            statusCount.put(
                issue.getStatus(),
                statusCount.getOrDefault(issue.getStatus(),0)+1
            );
        }

        Map<String,Object> stats = new HashMap<>();

        stats.put("category", categoryCount);
        stats.put("priority", priorityCount);
        stats.put("status", statusCount);

        return stats;
    }
    
    @PostMapping("/upload")
    public Issue uploadIssue(
            @RequestParam String description,
            @RequestParam String severity,
            @RequestParam String location,
            @RequestParam("image") MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();

        Path path = Paths.get("uploads/" + fileName);

        Files.write(path, file.getBytes());

        String prediction = mlService.getPrediction(description, severity);

        String category = prediction.split("\"category\": \"")[1].split("\"")[0];
        String priority = prediction.split("\"priority\": \"")[1].split("\"")[0];

        double predictedTime = Double.parseDouble(
                prediction.split("\"predictedResolutionTimeHours\": ")[1]
                        .replace("}", "")
        );

        Issue issue = new Issue();

        issue.setDescription(description);
        issue.setSeverity(severity);
        issue.setLocation(location);
        issue.setCategory(category);
        issue.setPriority(priority);
        issue.setPredictedResolutionTimeHours(predictedTime);
        issue.setStatus("Pending");
        issue.setImageUrl(fileName);

        return issueRepository.save(issue);
    }
}