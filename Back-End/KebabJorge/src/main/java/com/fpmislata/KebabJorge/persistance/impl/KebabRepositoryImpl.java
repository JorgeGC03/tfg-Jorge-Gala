package com.fpmislata.KebabJorge.persistance.impl;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fpmislata.KebabJorge.domain.entity.Kebab;
import com.fpmislata.KebabJorge.domain.repository.KebabRepository;
import com.fpmislata.KebabJorge.mapper.KebabMapper;
import com.fpmislata.KebabJorge.persistance.dao.KebabDAO;
import com.fpmislata.KebabJorge.persistance.model.KebabEntity;

@Repository
public class KebabRepositoryImpl implements KebabRepository{

    @Autowired
    KebabDAO kebabDAO;

    @Override
    public List<Kebab> getAll() {
        List<KebabEntity> kebabEntities = kebabDAO.findAll();
        return KebabMapper.mapper.toKebabList(kebabEntities);

    }

    @Override
    public Kebab findById(int kebabId) {

        KebabEntity kebabEntity = kebabDAO.findById(kebabId).orElse(null);
        return KebabMapper.mapper.toKebab(kebabEntity);}

    @Transactional
    @Override
    public Kebab insert(Kebab kebab) {
        KebabEntity kebabEntity = kebabDAO.save(KebabMapper.mapper.toKebabEntity(kebab));
        return KebabMapper.mapper.toKebab(kebabEntity);
    }

    @Transactional
    @Override
    public void deleteKebabById(Kebab kebab){
        kebabDAO.delete(KebabMapper.mapper.toKebabEntity(kebab));
    }

    @Transactional
    @Override
    public Kebab updateKebabById(Kebab kebab){
        KebabEntity kebabEntity = kebabDAO.save(KebabMapper.mapper.toKebabEntity(kebab));
        return KebabMapper.mapper.toKebab(kebabEntity);
    }
}
