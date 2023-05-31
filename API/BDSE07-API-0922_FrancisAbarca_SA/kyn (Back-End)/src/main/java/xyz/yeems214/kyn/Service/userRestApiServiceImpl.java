package xyz.yeems214.kyn.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import xyz.yeems214.kyn.Entity.Users;
import xyz.yeems214.kyn.Repository.UsersRepository;

import java.util.List;

@Service("userRestApiService")
public class userRestApiServiceImpl implements userRestApiService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(Users u) {
        String encryptedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encryptedPassword);

        usersRepository.save(u);
    }

    @Override
    public void deleteUser(Users u) {
        usersRepository.delete(u);
    }

    @Override
    public void deleteById(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public List<Users> searchByName(String key) {
        return usersRepository.search(key);
    }

    @Override
    public boolean userExists(String userName, String password) {
        Users u = usersRepository.findByUserName(userName);
        if (u != null && u.getPassword().equals(password)) {
            return true;
        }
        return false;
    }


}