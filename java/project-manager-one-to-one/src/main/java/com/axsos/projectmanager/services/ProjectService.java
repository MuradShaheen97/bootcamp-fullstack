package com.axsos.projectmanager.services;

import org.springframework.stereotype.Service;

import com.axsos.projectmanager.models.Project;
import com.axsos.projectmanager.models.User;
import com.axsos.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // CREATE or UPDATE.
    // save() creates when id is null and updates when id already exists.
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    // READ ONE project by id.
    public Project findProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    // READ the one project owned by a user.
    public Project findByOwner(User owner) {
        return projectRepository.findByOwner(owner).orElse(null);
    }

    // DELETE project.
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
