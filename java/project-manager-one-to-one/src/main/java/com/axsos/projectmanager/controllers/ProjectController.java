package com.axsos.projectmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.services.ProjectService;
import com.axsos.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(
            ProjectService projectService,
            UserService userService) {

        this.projectService = projectService;
        this.userService = userService;
    }

    /*
     * Helper method:
     * Returns the logged-in user id from session.
     */
    private Long getLoggedUserId(HttpSession session) {
        return (Long) session.getAttribute("userId");
    }

    /*
     * GET /dashboard
     *
     * Because this is ONE-TO-ONE:
     * - If the user has no project, show a button to create one.
     * - If the user has a project, show View/Edit/Delete directly.
     * - There is no Join Team button.
     */
    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findUser(userId);

        if (user == null) {
            session.invalidate();
            return "redirect:/";
        }

        Project project = projectService.findByOwner(user);

        model.addAttribute("user", user);
        model.addAttribute("project", project);

        return "dashboard";
    }

    // =========================
    // CREATE: Show form
    // =========================
    @GetMapping("/projects/new")
    public String newProject(
            HttpSession session,
            Model model) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findUser(userId);

        // One-to-one rule: user cannot create a second project.
        if (projectService.findByOwner(user) != null) {
            return "redirect:/dashboard";
        }

        model.addAttribute("project", new Project());

        return "new";
    }

    // =========================
    // CREATE: Process form
    // =========================
    @PostMapping("/projects")
    public String createProject(
            @Valid @ModelAttribute("project") Project project,
            BindingResult result,
            HttpSession session) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        User user = userService.findUser(userId);

        // Prevent a second project even if someone manually sends a POST request.
        if (projectService.findByOwner(user) != null) {
            return "redirect:/dashboard";
        }

        if (result.hasErrors()) {
            return "new";
        }

        // Connect the project to its one owner before saving.
        project.setOwner(user);
        projectService.saveProject(project);

        return "redirect:/dashboard";
    }

    // =========================
    // READ ONE
    // =========================
    @GetMapping("/projects/{id}")
    public String showProject(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project project = projectService.findProject(id);

        // Project must exist and belong to the logged-in user.
        if (project == null
                || !project.getOwner().getId().equals(userId)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("project", project);

        return "show";
    }

    // =========================
    // UPDATE: Show edit form
    // =========================
    @GetMapping("/projects/{id}/edit")
    public String editProject(
            @PathVariable("id") Long id,
            HttpSession session,
            Model model) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project project = projectService.findProject(id);

        if (project == null
                || !project.getOwner().getId().equals(userId)) {
            return "redirect:/dashboard";
        }

        model.addAttribute("project", project);

        return "edit";
    }

    // =========================
    // UPDATE: Process edit form
    // =========================
    @PostMapping("/projects/{id}/update")
    public String updateProject(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("project") Project formProject,
            BindingResult result,
            HttpSession session) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project databaseProject = projectService.findProject(id);

        if (databaseProject == null
                || !databaseProject.getOwner().getId().equals(userId)) {
            return "redirect:/dashboard";
        }

        if (result.hasErrors()) {
            return "edit";
        }

        /*
         * Update allowed fields on the existing database object.
         * This preserves its id, owner and createdAt.
         */
        databaseProject.setTitle(formProject.getTitle());
        databaseProject.setDescription(formProject.getDescription());
        databaseProject.setDueDate(formProject.getDueDate());

        projectService.saveProject(databaseProject);

        return "redirect:/dashboard";
    }

    // =========================
    // DELETE
    // =========================
    @PostMapping("/projects/{id}/delete")
    public String deleteProject(
            @PathVariable("id") Long id,
            HttpSession session) {

        Long userId = getLoggedUserId(session);

        if (userId == null) {
            return "redirect:/";
        }

        Project project = projectService.findProject(id);

        // Only the owner can delete the project.
        if (project != null
                && project.getOwner().getId().equals(userId)) {

            projectService.deleteProject(id);
        }

        return "redirect:/dashboard";
    }
}
