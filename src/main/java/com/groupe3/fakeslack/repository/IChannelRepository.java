package com.groupe3.fakeslack.repository;

import com.groupe3.fakeslack.entity.Channel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChannelRepository extends JpaRepository<Channel, Integer> {


}
