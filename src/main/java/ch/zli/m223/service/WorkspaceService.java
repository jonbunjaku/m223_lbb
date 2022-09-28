package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Workspace;

@ApplicationScoped
public class WorkspaceService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Workspace createWorkspace(Workspace workspace) {
        entityManager.persist(workspace);
        return workspace;
    }

    @Transactional
    public void deleteWorkspace(Long id) {
        var workspace = entityManager.find(Workspace.class, id);
        entityManager.remove(workspace);
    }

    public List<Workspace> getAllWorkspaces() {
        var workspace = entityManager.createQuery("FROM Workspace", Workspace.class);
        return workspace.getResultList();
    }
    @Transactional
    public Workspace updateWorkspace(Workspace workspace) {
        return entityManager.merge(workspace);
    }
}
