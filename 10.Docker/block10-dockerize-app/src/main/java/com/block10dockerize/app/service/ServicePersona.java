package com.block10dockerize.app.service;


import com.block10dockerize.app.dTOS.PersonaINputDto;
import com.block10dockerize.app.dTOS.PersonaOUTputDto;

import java.util.List;

public interface ServicePersona {

    public PersonaOUTputDto viewId(Integer id) throws Exception; //ok

    public List<PersonaOUTputDto> viewPerson(String name) throws Exception ; //ok

    PersonaOUTputDto update(Integer id, PersonaINputDto personaINputDto) throws Exception;//ok

    public void delete(Integer id) throws Exception; //ok

    public List<PersonaOUTputDto> viewall();

    public PersonaOUTputDto loadpersona(PersonaINputDto personaINputDto)throws Exception; //ok
}