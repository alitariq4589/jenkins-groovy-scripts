import io.jenkins.plugins.gitlabserverconfig.servers.GitLabServers
import io.jenkins.plugins.gitlabserverconfig.servers.GitLabServer
import jenkins.model.Jenkins

// Replace the following
def gitlabServerName = 'my-gitlab-server'
def gitlabServerUrl = 'https://gitlab.example.com'
// def credentialsId = 'your-credentials-id'           // Personal Access token from gitlab
// def secretTokenId = 'your-secret-token'          // This is optional and you may not need it

// Get the GitLabServers singleton
def gitLabServers = GitLabServers.get()

// Check if the GitLab server already exists
def existingServer = gitLabServers.findServer(gitlabServerName)

if (existingServer) {
    println "GitLab server '${gitlabServerName}' already exists."
} else {
    // Create a new GitLab server configuration
    def newServer = new GitLabServer(gitlabServerUrl, gitlabServerName, credentialsId)
    
    // Set additional properties
    newServer.setManageWebHooks(true)
    newServer.setManageSystemHooks(true)
    newServer.setImmediateHookTrigger(true)
    
    // Set the webhook secret token ID
    // newServer.setWebhookSecretCredentialsId(secretTokenId) // This may be optional

    // Add the new server to the list of GitLab servers
    gitLabServers.addServer(newServer)
    Jenkins.instance.save()
    println "GitLab server '${gitlabServerName}' added successfully."
}
