package com.fpmislata.KebabJorge.domain.repository;

import java.nio.ByteBuffer;
import java.util.List;

import com.fpmislata.KebabJorge.domain.entity.Kebab;

public interface KebabRepository {

    public List<Kebab> getAll();
    public Kebab findById(int kebabId);
    public Kebab insert(Kebab kebab);
    public void deleteKebabById(Kebab kebab);
    public Kebab updateKebabById(Kebab kebab);
}
