package iki.mashad.service.impl;

import iki.mashad.dto.RoleDto;
import iki.mashad.entity.Role;
import iki.mashad.mapper.RoleMapper;
import iki.mashad.repository.RoleRepository;
import iki.mashad.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role= RoleMapper.mapToRole(roleDto);
        Role savedRole=roleRepository.save(role);
        return RoleMapper.mapToRoleDto(savedRole);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles=roleRepository.findAll();
        return roles.stream().map(RoleMapper::mapToRoleDto).collect(Collectors.toList());
    }

    @Override
    public RoleDto getRoleById(Long roleId) {
        Role role=roleRepository.findById(roleId).orElseThrow(
                () -> new RuntimeException("Role Not Found !")
        );
        return RoleMapper.mapToRoleDto(role);
    }

    @Override
    public void delete(Long roleId) {
        Role role=roleRepository.findById(roleId).orElseThrow(
                () -> new RuntimeException("Role Not Found !")
        );
        roleRepository.delete(role);
    }
}
