package repository;

import core.Repository;

public class RepositoryImpl implements Repository {
    private Workspace root;

    public RepositoryImpl() {
        root = new Workspace("Workspace");
    }

    @Override
    public Workspace getWorkspace() {
        return root;
    }
}
