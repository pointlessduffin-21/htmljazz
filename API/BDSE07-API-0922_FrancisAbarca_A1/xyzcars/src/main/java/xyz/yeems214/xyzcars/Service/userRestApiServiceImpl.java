package xyz.yeems214.xyzcars.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.yeems214.xyzcars.Entity.Users;
import xyz.yeems214.xyzcars.Entity.UsersRepository;

@Service("userRestApiService")
public class userRestApiServiceImpl implements userRestApiService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void addUser(Users u) {
        usersRepository.save(u);
    }
}