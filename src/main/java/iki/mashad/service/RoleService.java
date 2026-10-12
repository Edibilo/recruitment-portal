package iki.mashad.service;

import iki.mashad.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    List<RoleDto> getAllRoles();
    RoleDto getRoleById(Long roleId);
    void delete(Long roleId);
}
